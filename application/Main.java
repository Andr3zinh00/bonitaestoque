package application;
<<<<<<< HEAD
	
import java.io.IOException;
=======

import java.util.List;

import com.bonitaestoque.model.Produto;
import com.bonitaestoque.services.CRUDServiceImpl;
>>>>>>> 6fc74d33aacbd6190497585f5bd3d3cc35af7353

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
<<<<<<< HEAD
			Parent root;
			root = FXMLLoader.load(getClass().getResource("../com/bonitaestoque/view/fxml/home.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch (IOException e) {
=======
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
>>>>>>> 6fc74d33aacbd6190497585f5bd3d3cc35af7353
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
