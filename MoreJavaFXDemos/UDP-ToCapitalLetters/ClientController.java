import java.io.IOException;
import java.net.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class ClientController {

	@FXML
	private TextArea textA;
	@FXML
	private TextField textF;

	@FXML
	void keyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			DatagramSocket clientSocket = null;
			try {
				clientSocket = new DatagramSocket();
				InetAddress IPAddress = InetAddress.getByName("localhost");

				sendToServer(clientSocket, IPAddress);
				getFromServer(clientSocket);

			} catch (Exception e) { 
			} finally { clientSocket.close(); }
		}
	}

	public void sendToServer(DatagramSocket socket, InetAddress ip) {
		String sentence = textF.getText();
		textF.setText("");

		DatagramPacket packet = new DatagramPacket(sentence.getBytes(), sentence.getBytes().length, ip, 9876);

		try {     
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  


	public void getFromServer(DatagramSocket socket) {
		byte[] receiveData = new byte[1024];
		DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
		try {
			socket.receive(packet);   
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] data = packet.getData();
		int len = packet.getLength();
		String modifiedSentence = new String(data).substring(0, len);
		textA.setText(modifiedSentence);
	}
}