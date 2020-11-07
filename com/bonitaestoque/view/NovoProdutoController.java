package com.bonitaestoque.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Produto;
import com.bonitaestoque.services.CRUDServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NovoProdutoController implements Initializable {

	@FXML
	private TextField lbNome;

	@FXML
	private TextField lbPrecoCompra;

	@FXML
	private TextField lbPrecoVenda;

	@FXML
	private TextArea lbDescricao;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	void handleCreate(ActionEvent event) {
		try {
		
				CRUDServiceImpl<Produto> crud = new CRUDServiceImpl<Produto>();
				Produto p = new Produto();
				p.setNome(lbNome.getText());
				p.setPrecoCompra((Double.parseDouble(lbPrecoCompra.getText())));
				p.setPrecoVenda((Double.parseDouble(lbPrecoVenda.getText())));
				p.setDescricao(lbDescricao.getText());
				crud.create(p);
				
				Node node = (Node) event.getSource();

				Stage stage = (Stage) node.getScene().getWindow();
				stage.close();
			
		} catch (Exception e) {
			
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}
		

	}
	
	@FXML
	void btnCancelar(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}

}
