package com.bonitaestoque.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Produto;

import application.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ItemProdutoController implements Initializable{

    @FXML
    private HBox hbProduct;

    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private Label productSize;
    
    @FXML
    private Label lbCategoria;

    @FXML
    void abrirTelaDetalhe(MouseEvent event) throws IOException {
    	Node node = (Node) event.getSource();
    	
    	Stage stage = (Stage) node.getScene().getWindow();
    	Stage stageDetalheProduto = new Stage();
    	Parent root = null;
    	
    	URL url = getClass().getResource("../view/fxml/DetalheProduto.fxml");
    	root = FXMLLoader.load(url); 

    	stageDetalheProduto.initModality(Modality.APPLICATION_MODAL);
        stageDetalheProduto.initOwner(stage);
    	
    	Scene scene = new Scene(root);
    	
    	
    	stageDetalheProduto.setScene(scene);
    	stageDetalheProduto.setMaximized(true);
    	stageDetalheProduto.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Observer.addOnChangeScreenLister(new Observer.OnChangeScreen() {
			
			@Override
			public void onScreenChanged(Object userData) {
				Produto p = (Produto) userData;
				System.out.println("setando produto"+ p.getNome());
				productName.setText(p.getNome());
				productPrice.setText(String.valueOf(p.getPrecoVenda()));
			}
		});
	}
    
}
