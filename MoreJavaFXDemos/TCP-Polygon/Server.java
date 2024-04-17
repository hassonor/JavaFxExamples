import java.io.*;
import java.net.*;

public class Server {
	
	public Server() {
		ServerSocket sc = null;
		Socket s = null;
		
		try {
			sc = new ServerSocket(7777);
			while(true) {
				s = sc.accept();
				new ServerThread(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 

		try {
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  
	public static void main(String[] args) {
		new Server();
	}
}