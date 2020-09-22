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
@Table(name = "tamanho")
public class Tamanho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;
	private Integer quantidade;
	
	public Tamanho(String tipo, Integer quantidade, List<Produto> list_produto) {
		super();
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.list_produto = list_produto;
	}

	@ManyToMany
	@JoinColumn(name = "product_list", referencedColumnName = "id")
	private List<Produto> list_produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Tamanho [id=" + id + ", tipo=" + tipo + ", quantidade=" + quantidade + ", list_produto=" + list_produto +  "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getList_produto() {
		return list_produto;
	}

	public void setList_produto(List<Produto> list_produto) {
		this.list_produto = list_produto;
	}
	

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
}
