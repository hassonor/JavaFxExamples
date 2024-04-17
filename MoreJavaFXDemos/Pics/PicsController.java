import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PicsController {

	@FXML
	private ImageView img;

	@FXML
	private Label title;

	private String[] titels = new String[] {"Title1", "Title2", "Title3", "Title4"};
	private int count = 1;
	final int N = 4;    

	public void initialize() {
		setPic();
	}    	

	@FXML
	void jumpPressed(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setHeaderText("Enter number between 1 to " + N);

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			try {
				int num = Integer.parseInt(result.get());
				if (num < 1 || num > N) return;
				count = num;
				setPic();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("OOps!");
				alert.setContentText("Must be a number");
				alert.showAndWait();
			}
		}
	}

	@FXML
	void nextPressed(ActionEvent event) {
		count++;
		if (count > N)
			count = 1;
		setPic();
	}

	private void setPic() {
		FileInputStream input;
		try {
			input = new FileInputStream("pic" + count + ".jpg");
			Image image = new Image(input);
			img.setImage(image);
			setTitle();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void setTitle() {
		title.setText(titels[count - 1]);
	}
}
