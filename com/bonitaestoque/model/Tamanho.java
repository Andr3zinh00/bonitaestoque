package com.bonitaestoque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tamanho")
public class Tamanho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipo;
	private int quantidade;

	public Tamanho(String tipo, int quantidade) {
		this.tipo = tipo;
		this.quantidade = quantidade;
	}
//
//	@ManyToMany
//	@JoinColumn(name = "product_list", referencedColumnName = "id")
//	private List<Produto> list_produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Tamanho [id=" + id + ", tipo=" + tipo + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
