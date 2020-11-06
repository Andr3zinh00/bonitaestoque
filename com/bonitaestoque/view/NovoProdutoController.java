package com.bonitaestoque.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Categoria;
import com.bonitaestoque.model.Produto;
import com.bonitaestoque.model.Tamanho;
import com.bonitaestoque.services.CRUDServiceImpl;

import application.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

	private List<Categoria> listCategoria = new ArrayList<Categoria>();
	private List<Tamanho> listTamanho = new ArrayList<Tamanho>();

	private boolean valido = true;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			listCategoria();
			listTamanho();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listTamanho() throws IOException {
		Node[] nodes = new Node[listTamanho.size()];
		for (int i = 1; i <= listTamanho.size(); i++) {
			nodes[i] = setTamanho(nodes[i], null);
			vbTamanho.getChildren().add(nodes[i]);
		}
	}

	private Node setTamanho(Node node, Object t) throws IOException {
		node = FXMLLoader.load(getClass().getResource("../view/fxml/TagTamanho.fxml"));
		Observer.notifyAllListeners(t);
		return node;
	}

	public void listCategoria() throws IOException {
		Node[] nodes = new Node[listCategoria.size()];
		for (int i = 1; i < listCategoria.size(); i++) {
			Categoria c = listCategoria.get(i);
			nodes[i] = setCategoria(nodes[i], c);
			hbCategoria.getChildren().add(nodes[i]);
		}
	}

	private Node setCategoria(Node node, Object object) throws IOException {
		node = FXMLLoader.load(getClass().getResource("../view/fxml/TagCategoria.fxml"));
		Observer.notifyAllListeners(object);
		return node;
	}

	@FXML
	void CriarNovoProduto(ActionEvent event) {
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
	void addTamanho(ActionEvent event) throws IOException {
		Tamanho t = new Tamanho(lbTamanho.getText().toUpperCase(), Integer.parseInt(lbQuantidade.getText()));
		listTamanho.add(t);
		Node node = null;
		node = setTamanho(node, t);
		vbTamanho.getChildren().add(node);
	}

	@FXML
	void addCategoria(ActionEvent event) throws IOException {
		Node node = null;
		Categoria c = new Categoria(null, false, lbCategoria.getText(), null);
		listCategoria.add(c);
		node = setCategoria(node, c);
		hbCategoria.getChildren().add(node);
	}

	@FXML
	void bntCancelar(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}

}
