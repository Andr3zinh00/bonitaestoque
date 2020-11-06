package com.bonitaestoque.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Produto;
import com.bonitaestoque.services.CRUDServiceImpl;

import application.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetalheProdutoController implements Initializable {

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

	@FXML
	private Text lbIdProduto;

	private Produto p;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Observer.addOnChangeScreenLister(new Observer.OnChangeScreen() {

			@Override
			public void onScreenChanged(Object userData) {

				if (p == null) {
					setCamposProduto(userData);
				}

			}
		});
	}

	protected void setCamposProduto(Object userData) {
		p = (Produto) userData;
		lbIdProduto.setText("" + p.getId());
		lbNome.setText(p.getNome());
		lbPrecoCompra.setText("" + p.getPrecoCompra());
		lbPrecoVenda.setText("" + p.getPrecoVenda());
		lbDescricao.setText(p.getDescricao());

	}

	@FXML
	void btnCancelar(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}

	@FXML
	void deletarProduto(ActionEvent event) {
		try {
			CRUDServiceImpl<Produto> crud = new CRUDServiceImpl<Produto>();
			crud.delete(Produto.class, p.getId());

			Node node = (Node) event.getSource();

			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}

	}
	
	@FXML
	void atualizarProduto(ActionEvent event) {
		try {
			CRUDServiceImpl<Produto> crud = new CRUDServiceImpl<Produto>();
			p.setDescricao(lbDescricao.getText());
			p.setNome(lbNome.getText());
			p.setPrecoCompra((Double.parseDouble(lbPrecoCompra.getText())));
			p.setPrecoVenda((Double.parseDouble(lbPrecoVenda.getText())));
			crud.update(p);

			Node node = (Node) event.getSource();

			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}
	}

}
