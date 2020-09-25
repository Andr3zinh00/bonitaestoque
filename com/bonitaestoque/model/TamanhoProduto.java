package com.bonitaestoque.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tamanho_produto")
public class TamanhoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	@JoinColumn(name = "id_tamanho", referencedColumnName = "id")
	private List<Tamanho> tamanho;

	@OneToMany
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private List<Produto> produto;

	public TamanhoProduto(Long id, List<Tamanho> tamanho, List<Produto> produto, Integer quantidade) {
		this.id = id;
		this.tamanho = tamanho;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public TamanhoProduto(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public TamanhoProduto() {

	}
	

	private Integer quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Tamanho> getTamanho() {
		return tamanho;
	}

	public void setTamanho(List<Tamanho> tamanho) {
		this.tamanho = tamanho;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
