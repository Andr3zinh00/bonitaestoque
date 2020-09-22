package application;
	
import java.io.IOException;

import com.bonitaestoque.model.Connection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Connection.getInstance();

			Parent root;
			root = FXMLLoader.load(getClass().getResource("../com/bonitaestoque/view/fxml/Home.fxml"));
			
			primaryStage.setScene(new Scene(root));
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
}