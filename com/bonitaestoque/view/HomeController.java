package com.bonitaestoque.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("HELLO");
		listProduct();
		
	}
	
	public void listProduct() {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("../view/fxml/ItemProduct.fxml"));
                
                vbList.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
	}

}
