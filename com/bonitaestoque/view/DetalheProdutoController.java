package com.bonitaestoque.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Categoria;
import com.bonitaestoque.model.Produto;
import com.bonitaestoque.model.Tamanho;

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
	private HBox hbCategoria;

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
					try {
						listCategoria();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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

	public void listTamanho() throws IOException {
		Node[] nodes = new Node[100];
		for (int i = 1; i <= 0; i++) {
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
		Node[] nodes = new Node[10];
		for (int i = 1; i < 0; i++) {
			nodes[i] = setCategoria(nodes[i], "");
			hbCategoria.getChildren().add(nodes[i]);
		}
	}

	private Node setCategoria(Node node, Object object) throws IOException {
		node = FXMLLoader.load(getClass().getResource("../view/fxml/TagCategoria.fxml"));
		Observer.notifyAllListeners(object);
		return node;
	}

	@FXML
	void addTamanho(ActionEvent event) throws IOException {
		System.out.println("AddTam:" + lbTamanho.getText() + " " + lbQuantidade.getText());
		Tamanho t = new Tamanho(lbTamanho.getText(), Integer.parseInt(lbQuantidade.getText()));
		Node node = null;
		node = setTamanho(node, t);
		vbTamanho.getChildren().add(node);
	}

	@FXML
	void addCategoria(ActionEvent event) throws IOException {
		System.out.println("AddCat:" + lbCategoria.getText());
		Node node = null;
		Categoria c = new Categoria(null, false, lbCategoria.getText(), null);
		node = setCategoria(node, c);
		hbCategoria.getChildren().add(node);
		System.out.println("hb " + hbCategoria.getId());
	}

	@FXML
	void bntCancelar(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}

}
