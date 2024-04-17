import java.io.*;
import java.util.HashMap;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class MyCalanderController {
	@FXML
	private TextArea area;
	@FXML
	private ComboBox<String> dayC, monthC, yearC;
	@FXML
	private Button load, save;
	@FXML
	private VBox vbox;

	private HashMap<Date, String> h;


	public void initialize() {
		initComboBox();
		loadFromFile();
	}
	
	private void initComboBox() {
		final int DAYS = 31, MONTHS = 12, START_YEAR = 2020, END_YEAR = 2022;
		h = new HashMap<Date, String>();

		for (int i = 1; i <= DAYS; i++)
			dayC.getItems().add(String.valueOf(i));
		dayC.setValue("1");

		for (int i = 1; i <= MONTHS; i++)
			monthC.getItems().add(String.valueOf(i));
		monthC.setValue("1");

		for (int i = START_YEAR; i <= END_YEAR; i++)
			yearC.getItems().add(String.valueOf(i));
		yearC.setValue("2020");
	}

	@FXML
	void loadPressed(ActionEvent event) {
		Date d = new Date(Integer.parseInt(dayC.getValue()), 
				Integer.parseInt(monthC.getValue()),
				Integer.parseInt(yearC.getValue()));

		area.setText(h.get(d));
	}

	@FXML
	void savePressed(ActionEvent event) {
		Date d = new Date(Integer.parseInt(dayC.getValue()), 
				Integer.parseInt(monthC.getValue()),
				Integer.parseInt(yearC.getValue()));
		h.put(d,area.getText());

		addClosingEvent();
	}

	private void addClosingEvent() {
		Stage stage = (Stage)((Node) vbox).getScene().getWindow();
		stage.getScene().getWindow().addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, event1 -> {

			saveToFile();
		});	
	}

	private void loadFromFile() {

		File file = getFile();

		if (file != null) {
			try {

				FileInputStream fi = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fi);
				h = (HashMap<Date, String>)ois.readObject();
				ois.close();
				fi.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveToFile() {

		File file = getFile();

		try {
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(h);
			out.close();
			fo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getFile() {
		FileChooser fileChooser = new FileChooser(); 
		fileChooser.setTitle("select a file"); 
		fileChooser.setInitialDirectory(new File(".")); 
		return fileChooser.showOpenDialog(null);
	}
}
