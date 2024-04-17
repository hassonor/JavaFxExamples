import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class WordGameController {

	@FXML
	private GridPane grid;

	@FXML
	private TextField textF;

	private Button[] buttons;
	private Dictionary d;

	private final int SIZE = 7;

	public void initialize() {
		d = new Dictionary();
		buttons = new Button[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			buttons[i] = new Button(d.getRandomLetter() + "");
			buttons[i].setPrefSize(grid.getPrefWidth() / SIZE, grid.getPrefHeight() / SIZE);
			buttons[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					handleButton(e);
				}
			});
			grid.add(buttons[i], i % SIZE, i / SIZE);
		}	
	}

	@FXML
	void keyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			if (d.isLegal(textF.getText()))
				JOptionPane.showConfirmDialog(null, "Legal word", "Legal word", JOptionPane.CLOSED_OPTION);
			else
				JOptionPane.showConfirmDialog(null, "Illegal word", "Illegal word", JOptionPane.CLOSED_OPTION);
		}
		textF.setText("");
	}
	
	private void handleButton(ActionEvent e) {
		textF.appendText(((Button)e.getSource()).getText());
		((Button)e.getSource()).setText(d.getRandomLetter() + "");
	}
}
