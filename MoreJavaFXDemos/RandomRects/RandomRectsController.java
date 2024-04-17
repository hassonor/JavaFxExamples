import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class RandomRectsController {

	@FXML
	private Canvas canv1;

	@FXML
	private Canvas canv2;

	private LinkedList<Rectangle> rects1, rects2;
	private GraphicsContext gc1, gc2;

	private final int NUM = 10;

	public void initialize() {
		gc1 = canv1.getGraphicsContext2D();
		gc2 = canv2.getGraphicsContext2D();

		rects1 = new LinkedList<Rectangle>();
		rects2 = new LinkedList<Rectangle>();

		Random rnd = new Random();
		for (int i = 0; i < NUM; i++) {
			int size = rnd.nextInt(91) + 10;
			rects1.add(new Rectangle(rnd.nextInt(400), rnd.nextInt(140), size, size));
		}

		fillRects();
	}

	@FXML
	void pressed(MouseEvent e) {
		Rectangle rs = getSmallest();
		if (rs.contains(new Point2D(e.getX(), e.getY()))) {
			int size = (int)rs.getWidth();
			removeSmallest();
			rects2.add(new Rectangle(0, 0, size, size));
		}
		else {
			JOptionPane.showConfirmDialog(null, "not the smallest!", "Error", JOptionPane.CLOSED_OPTION);
		}
		fillRects();
	}

	private void fillRects() {
		gc1.clearRect(0, 0, canv1.getWidth(), canv1.getHeight());
		gc2.clearRect(0, 0, canv2.getWidth(), canv2.getHeight());

		for (int i = 0; i < rects1.size(); i++)
			gc1.strokeRect(rects1.get(i).getX(), rects1.get(i).getY(), rects1.get(i).getWidth(), rects1.get(i).getHeight());
		for (int i = 0; i < rects2.size(); i++)
			gc2.strokeRect(rects2.get(i).getX(), rects2.get(i).getY(), rects2.get(i).getWidth(), rects2.get(i).getHeight());
	}

	private Rectangle getSmallest() {
		if (rects1.size() == 0)
			return null;
		Rectangle smallest = rects1.get(0);
		for (int i = 1; i < rects1.size(); i++) {
			if (rects1.get(i).getWidth() < smallest.getWidth()) 
				smallest = rects1.get(i);
		}
		return smallest;
	}

	private void removeSmallest( ) {
		rects1.remove(getSmallest());
	}
}
