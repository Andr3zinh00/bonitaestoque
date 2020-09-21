
package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bonitaestoque.model.Categoria;
import com.bonitaestoque.model.Produto;
import com.bonitaestoque.services.RelatorioServiceImpl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			RelatorioServiceImpl report = new RelatorioServiceImpl();
			List<Categoria> list = new ArrayList<Categoria>();
			List<Produto> listP = new ArrayList<Produto>();
			
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			list.add(new Categoria("DESC", false, "Tênis", 40, listP));
			
//			public Categoria(String descricao, Boolean danificado, String nome, Integer quantidade, List<Produto> produtos) {
//				super();
//				this.produtos = produtos;
//				this.descricao = descricao;
//				this.danificado = danificado;
//				this.nome = nome;
//				this.quantidade = quantidade;
//			}
			
			report.createReport(list);
			Parent root;
			root = FXMLLoader.load(getClass().getResource("../com/bonitaestoque/view/fxml/home.fxml"));
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
