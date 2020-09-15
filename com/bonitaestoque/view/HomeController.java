package com.bonitaestoque.view;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Produto;
import com.bonitaestoque.services.CRUDServiceImpl;

import javafx.fxml.Initializable;

public class HomeController implements Initializable {

	@FXML
	private ScrollPane scrList = null;

	@FXML
	private Button button;

	@FXML
	private VBox vbList = null;

	@FXML
	private Button btnNovoProduto;
	private CRUDServiceImpl<Produto> service = new CRUDServiceImpl<Produto>();

	// lista de produtos
	private List<Produto> list = new ArrayList<Produto>();
	private boolean isLoadingProducts = true;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("HELLO");
		listProduct();

		System.out.println("Antes de printar os produtos");

		getAllProducts();
	}

	/**
	 * 
	 */
	public void getAllProducts() {

		try {

			Task<List<Produto>> task = new Task<List<Produto>>() {

				@Override
				protected List<Produto> call() throws Exception {
					System.out.println("entrei");
					return service.getAll(Produto.class);
				}
			};

			// como o nome sugere, vai ser chamado quando a task for sucedida
			/**
			 *  JOAO, FAZ O QUE VC TAVA FAZENDO NO listProducts 
			 *  AQUI DENTRO NO handle(), SE VC USAR "task.getValue()"
			 *  VAI PEGAR A LISTA DE TODOS OS PRODUTOS DO BANCO DE DADOS 
			 */
			task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

				@Override
				public void handle(WorkerStateEvent event) {
					System.out.println("handle");
					list.addAll(task.getValue());
					System.out.println(isLoadingProducts);
					System.out.println(list);
					
					//isso é apenas um teste pra testar o update, ta funcionando
//					Produto p = list.get(0);
//					p.setNome("TESTE2");
//					service.update(p);

				}
			});

			// USAR O ON FAILED PRA TRATAR ERROR E.G: MOSTRAR MENSAGENS DE ERRO
			// task.setOnFailed(value);
			new Thread(task).start();
			System.out.println(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listProduct() {
		Node[] nodes = new Node[10];
		for (int i = 0; i < nodes.length; i++) {
			try {
				nodes[i] = FXMLLoader.load(getClass().getResource("../view/fxml/itemProduct.fxml"));

				vbList.getChildren().add(nodes[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
