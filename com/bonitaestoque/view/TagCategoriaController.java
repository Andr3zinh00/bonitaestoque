package com.bonitaestoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TagCategoriaController implements Initializable{

    @FXML
    private HBox itemCagoria;

    @FXML
    private Text lbCategoriaNome;

    @FXML
    private Button lbCategoriaExcluir;

    @FXML
    void excluir(ActionEvent event) {
    	Parent node = lbCategoriaExcluir.getParent().getParent();
        System.out.println(node.getId());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
