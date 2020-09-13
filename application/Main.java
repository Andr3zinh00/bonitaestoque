package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bonitaestoque");
	private EntityManager et = emf.createEntityManager();


	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.println("asdasdasasxiaios");
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
