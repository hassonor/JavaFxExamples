import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.*;

public class ClientController {

	@FXML
	private Canvas canv;

	private GraphicsContext gc;

	public void initialize() {
		gc = canv.getGraphicsContext2D();	
	}

	@FXML
	void addPressed(ActionEvent event) {
		try {
			new ClientThread(this, "127.0.0.1").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addPolygon(Polygon p) {
		p.draw(gc);
	}
}
