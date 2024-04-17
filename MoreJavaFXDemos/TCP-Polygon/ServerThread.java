import java.awt.Point;
import java.io.*;
import java.net.Socket;
import java.util.Random;

public class ServerThread extends Thread {
	private Socket s = null;

	public ServerThread(Socket socket) {
		this.s = socket;
	}

	@Override
	public void run() {
		super.run();
		try {
			handleReadAndWrite();
		}    
		catch (Exception e) {  }
	}    

	public void handleReadAndWrite() throws Exception{
		OutputStream outputStream = s.getOutputStream();
		ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
		InputStream inputStream = s.getInputStream();   

		// Get num from client
		int num = inputStream.read();
		// build the polygon and send to client
		objOutputStream.writeObject(buildPolygon(num));

		inputStream.close();
		objOutputStream.close();
		outputStream.close();
		s.close();
	}

	public Polygon buildPolygon(int num) {
		Random r = new Random();
		Point arr[] = new Point[num];
		for (int i = 0; i < num; i++) 
			arr[i] = new Point(r.nextInt(400), r.nextInt(400));
		return new Polygon(arr);
	}
}