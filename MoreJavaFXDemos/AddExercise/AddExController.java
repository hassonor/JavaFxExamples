import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class AddExController {

	@FXML
    private GridPane grid;
    
    private Button[] buttons;
    private Button btnX, btnY;
	private final int SIZE = 5;
	private int count = 0;
    
    public void initialize() {
    	buttons = new Button[SIZE * SIZE];
    	
		for (int i = 0; i < SIZE * SIZE; i++) {
			buttons[i] = new Button(""+(i+1));
			buttons[i].setPrefSize(grid.getPrefWidth() / 5, grid.getPrefHeight() / 5);
			buttons[i].setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			    	handleButton(e);
			    }
			});
			grid.add(buttons[i], i % 5, i / 5);
		}	
    }
    
    @FXML
    void finishPressed(ActionEvent e) {
    	JOptionPane.showConfirmDialog(null, "WOW! you solved " + count, "Well done!", JOptionPane.CLOSED_OPTION);
		count = 0;
    }
    
    private void handleButton(ActionEvent e) {
    	if (btnX == null) {
			btnX = (Button)e.getSource();
		}
		else if (btnY == null) {
			btnY = (Button)e.getSource();
		}
		else {
			Button btnZ = (Button)e.getSource();
			if (Integer.parseInt(btnX.getText()) + Integer.parseInt(btnY.getText()) == Integer.parseInt(btnZ.getText())) {
				btnX.setText("");
				btnX.setDisable(true);
				btnY.setText("");
				btnY.setDisable(true);
				btnZ.setText("");
				btnZ.setDisable(true);
				count++;
			}
			else {
				JOptionPane.showConfirmDialog(null, "You are wrong!", "Error", JOptionPane.CLOSED_OPTION);
			}
			btnX = null;
			btnY = null;
		}	
    }
}