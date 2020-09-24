package com.bonitaestoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Categoria;

import application.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TagCategoriaController implements Initializable {

	@FXML
	private HBox itemCagoria;

	@FXML
	private Text lbCategoriaNome;

	@FXML
	private Button lbCategoriaExcluir;

	private Categoria c;

	@FXML
	void excluir(ActionEvent event) {
		Parent node = lbCategoriaExcluir.getParent().getParent();
		System.out.println(node.getId());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Observer.addOnChangeScreenLister(new Observer.OnChangeScreen() {

			@Override
			public void onScreenChanged(Object userData) {
				if (c == null) {
					c = (Categoria) userData;
					System.out.println("Categoria: " + userData.toString());
					lbCategoriaNome.setText(c.getNome());
				}
			}
		});

	}

}
