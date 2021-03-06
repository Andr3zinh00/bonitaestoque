package com.bonitaestoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.bonitaestoque.model.Tamanho;

import application.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TagTamanhoController implements Initializable {

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
	Tamanho t;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Observer.addOnChangeScreenLister(new Observer.OnChangeScreen() {

			@Override
			public void onScreenChanged(Object userData) {
				if (t == null) {
					t = (Tamanho) userData;
					lbTamanhoNome.setText(t.getTipo());
					lbTamanhoQtd.setText("" + t.getQuantidade());
				}
			}
		});
	}

	@FXML
	void bntExcluir(ActionEvent event) {

	}

	@FXML
	void bntMais(ActionEvent event) {
		int tamanhoQtd = Integer.parseInt(lbTamanhoQtd.getText());

		tamanhoQtd += 1;

		lbTamanhoQtd.setText("" + tamanhoQtd);
	}

	@FXML
	void bntMenos(ActionEvent event) {
		int tamanhoQtd = Integer.parseInt(lbTamanhoQtd.getText());
		if (tamanhoQtd == 0) {
			return;
		}

		tamanhoQtd -= 1;

		lbTamanhoQtd.setText("" + tamanhoQtd);
	}
}
