package com.bonitaestoque.view;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Produto;
import com.bonitaestoque.services.CRUDServiceImpl;

import application.Observer;
import javafx.fxml.Initializable;

public class HomeController implements Initializable {

	@FXML
	private ScrollPane scrList = null;
	
	@FXML
    private AnchorPane anContainer;

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
		try {
			
			Observer.addOnChangeScreenLister(new Observer.OnChangeScreen() {
				
				@Override
				public void onScreenChanged(Object userData) {
				}
			});
			
			getAllProducts();
			listProduct();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Antes de printar os produtos");

	}
	
    @FXML
    void novoProduto(ActionEvent event) throws IOException {
    	Node node = (Node) event.getSource();
    	
    	Stage stage = (Stage) node.getScene().getWindow();
    	Stage stageNovoProduto = new Stage();
    	Parent root = null;
    	
    	URL url = getClass().getResource("../view/fxml/NovoProduto.fxml");
    	root = FXMLLoader.load(url); 

    	stageNovoProduto.initModality(Modality.APPLICATION_MODAL);
        stageNovoProduto.initOwner(stage);
    	
    	Scene scene = new Scene(root);
    	stageNovoProduto.setScene(scene);
    	stageNovoProduto.setMaximized(true);
    	stageNovoProduto.show();
    }

	/**
	 * 
	 */
	public void getAllProducts() {

		try {

			Task<List<Produto>> task = new Task<List<Produto>>() {

				@Override
				protected List<Produto> call() throws Exception {
					
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

	public void listProduct() throws IOException, InterruptedException {
		vbList.getChildren().clear();
        Node[] nodes = new Node[list.size()];
        for (int i = 0; i < list.size(); i++) {
        		Object obj = list.get(i);
        		Produto p = (Produto) obj;
        		System.out.println(p.getNome());
        		nodes[i] = setProduct(nodes[i], obj);    
                vbList.getChildren().add(nodes[i]);
        }
	}

	private Node setProduct(Node nodes, Object object) throws IOException {
		Observer.notifyAllListeners(object);
			nodes = FXMLLoader.load(getClass().getResource("../view/fxml/ItemProduto.fxml"));
		return nodes;
	}
	
	@FXML
    void listSize(ActionEvent event) throws IOException, InterruptedException {
		listProduct();
	}

}
