import java.util.LinkedList;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class BoardController {

	@FXML
	private Canvas can;

	private LinkedList<Message> msgs;
	private GraphicsContext gc;

	@FXML
	void pressed(MouseEvent event) {
		boolean del = false;
		for (Message m : msgs) {
			if (Math.abs(event.getX() - m.getX()) <= 10 &&
					Math.abs(event.getY() - m.getY()) <= 10) {
				del = true;
				msgs.remove(m);
				break;
			}
		}
		if (!del) {
			String str = JOptionPane.showInputDialog("Enter message:");
			msgs.add(new Message((int)event.getX(), (int)event.getY(), str));
		}
		drawMessages();

	}

	public void initialize() {
		gc = can.getGraphicsContext2D();
		msgs = new LinkedList<Message>();
	}

	private void drawMessages() {
		gc.clearRect(0, 0, can.getWidth(), can.getHeight());
		for (Message m : msgs) {
			gc.strokeText(m.getText(), m.getX(), m.getY());
		}
	}
}
