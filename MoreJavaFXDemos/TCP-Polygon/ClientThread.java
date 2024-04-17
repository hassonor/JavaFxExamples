import java.io.*;
import java.net.*;

public class ClientThread extends Thread {

	private ClientController cont;
	private String ip;

	public ClientThread(ClientController cont, String ip) {
		this.cont = cont;
		this.ip = ip;
	}
	public void run() {
		super.run();
		try {
			handleReadAndWrite();
		} catch (Exception e) { e.printStackTrace(); }	
	}  

	public void handleReadAndWrite() throws Exception {
		Socket s = new Socket(ip, 7777);
		OutputStream outputStream = s.getOutputStream();

		InputStream inputStream = s.getInputStream();
		ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

		// Write num to server
		outputStream.write(4);

		// Get Polygon from server
		Polygon p = (Polygon)objInputStream.readObject();
		cont.addPolygon(p);

		outputStream.close();
		inputStream.close();
		objInputStream.close();
		s.close();
	}
}