import java.io.*;
import java.net.*;

public class UDPServer {
	public UDPServer() {
		try {
			while(true)
				sendAndRecieve();
		} catch(Exception e1) {}
	} 
	public static void main(String[] args) {
		new UDPServer();
	}

	public void sendAndRecieve()  {
		DatagramSocket serverSocket = null;
		try {
			serverSocket = new DatagramSocket(9876);
			// receive from client      
			byte[] receive = new byte[1024];
			DatagramPacket packet = new DatagramPacket(receive, receive.length);
			serverSocket.receive(packet);

			String msg = new String(packet.getData()).substring(0, packet.getLength());
			msg = msg.toUpperCase();

			// send to client
			int p = packet.getPort(); 
			InetAddress add = packet.getAddress();
			packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, add, p); 	
			serverSocket.send(packet);
		} catch (IOException e1) { 
		} finally { serverSocket.close(); }
	}
}
