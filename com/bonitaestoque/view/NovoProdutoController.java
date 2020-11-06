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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
	private VBox vbTamanho;

	@FXML
	private HBox hbTamanho;

	@FXML
	private Text lbTamanhoNome;

	@FXML
	private Button btnTamanhoMenos;

	@FXML
	private Text lbTamanhoQtd;

	@FXML
	private Button btnTamanhoMais;

	@FXML
	private Button btnTamanhoExcluir;

	@FXML
	private TextField lbTamanho;

	@FXML
	private TextField lbQuantidade;

	@FXML
	private Button btnTamanhoAdd;

	@FXML
	private TextField lbCategoria;

	@FXML
	private Button btnCategoriaAdd;

	@FXML
	public HBox hbCategoria;

	@FXML
	private HBox itemCagoria;

	@FXML
	private Text lbCategoriaNome;

	@FXML
	private Button lbCategoriaExcluir;

	@FXML
	private HBox itemCagoria1;

	@FXML
	private Text lbCategoriaNome1;

	@FXML
	private Button lbCategoriaExcluir1;

	@FXML
	private HBox itemCagoria2;

	@FXML
	private Text lbCategoriaNome2;

	@FXML
	private Button lbCategoriaExcluir2;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	private boolean valido = true;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	void CriarNovoProduto(ActionEvent event) {
		try {
			valido = true;
			validationField(lbNome);
			validationField(lbPrecoCompra);
			validationField(lbPrecoVenda);
			validationField(lbDescricao);

			if (valido) {
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
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}
		

	}

	private void validationField(TextArea lb) {
		if (lb.getText().equals("")) {
			lb.setStyle("-fx-border-color: #f54260; -fx-border-radius: 4;");
		}
	}

	private void validationField(TextField lb) {
		if (lb.getText().equals("")) {
			lb.setStyle("-fx-border-color: #f54260; -fx-border-radius: 4;");
			valido = false;
		}
	}

	@FXML
	void btnCancelar(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}

}
