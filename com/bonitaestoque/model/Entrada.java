package com.bonitaestoque.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrada")
public class Entrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Date data_entrada;
	private Float preco_custo;

	@ManyToOne
	@JoinColumn(name = "id_fornecedor", referencedColumnName = "id")
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id")
	private Funcionario funcionario;

	@ManyToMany
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private List<Produto> entrada_produtos;

	public Entrada(String descricao, Date data_entrada, Float preco_custo, Fornecedor fornecedor,
			Funcionario funcionario, List<Produto> entrada_produtos) {
		super();
		this.entrada_produtos = entrada_produtos;
		this.descricao = descricao;
		this.data_entrada = data_entrada;
		this.preco_custo = preco_custo;
		this.fornecedor = fornecedor;
		this.funcionario = funcionario;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Produto> getEntrada_produtos() {
		return entrada_produtos;
	}

	public void setEntrada_produtos(List<Produto> entrada_produtos) {
		this.entrada_produtos = entrada_produtos;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", descricao=" + descricao + ", data_entrada=" + data_entrada + ", preco_custo="
				+ preco_custo + ", fornecedor=" + fornecedor + ", entrada_produtos=" + entrada_produtos + "]";
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

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Float getPreco_custo() {
		return preco_custo;
	}

	public void setPreco_custo(Float preco_custo) {
		this.preco_custo = preco_custo;
	}

}
