import java.awt.Point;
import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;

public class Polygon implements Serializable {
	private Point[] arr;
	public Polygon(Point[] arr) {
		this.arr = arr;
	}
	public void draw(GraphicsContext gc) {
		double[] xs = new double[arr.length];
		double[] ys = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			xs[i] = arr[i].x;
			ys[i] = arr[i].y;
		}	
		gc.fillPolygon(xs, ys, arr.length);		
	}
}