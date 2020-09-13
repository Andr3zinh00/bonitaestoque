package application;

import java.util.List;

import com.bonitaestoque.model.Produto;
import com.bonitaestoque.services.CRUDServiceImpl;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			CRUDServiceImpl<Produto> crudS=new CRUDServiceImpl<Produto>();
			System.out.println(crudS.getByName(Produto.class, "Camisa"));
//			double a = 12.22131;
//			Produto p = new Produto("Camisa Lacoste", a, "large");
//			crudS.create(p);
//			
//			List<Produto> plist =crudS.getAll(Produto.class);
//			crudS.delete(Produto.class,plist.get(0).getId());
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
