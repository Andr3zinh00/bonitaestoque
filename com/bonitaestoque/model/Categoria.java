package com.bonitaestoque.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Boolean danificado;
	private String nome;

	@ManyToMany
	@JoinColumn(name = "id")
	private List<Produto> produtos;

	public Categoria(String descricao, Boolean danificado, String nome, List<Produto> produtos) {
		super();
		this.produtos = produtos;
		this.descricao = descricao;
		this.danificado = danificado;
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descricao=" + descricao + ", danificado=" + danificado + ", nome=" + nome
				+ ", produtos=" + produtos + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getDanificado() {
		return danificado;
	}

	public void setDanificado(Boolean danificado) {
		this.danificado = danificado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
