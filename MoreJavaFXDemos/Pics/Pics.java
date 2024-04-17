import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Pics extends Application{ 
	
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("Pics.fxml")); 
		Scene scene = new Scene(root, 600, 400); 
		stage.setTitle("Pics"); 
		stage.setScene(scene); 
		stage.show();
	} 
	
	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
} 