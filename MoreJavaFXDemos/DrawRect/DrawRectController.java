import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class DrawRectController {
    
    @FXML
    private Canvas canv;
    
    private GraphicsContext gc;
    
	public void initialize() {
    	gc = canv.getGraphicsContext2D(); 
    }

    @FXML
    void drawRect(ActionEvent event) {
    	gc.setFill(Color.RED);
    	gc.fillRect(50, 50, 200, 200);
    }
}
