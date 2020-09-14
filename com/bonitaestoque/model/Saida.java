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
@Table(name = "saida")
public class Saida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data_saida;
	private Integer quantidade;
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "funcionarioId", referencedColumnName = "id")
	private Funcionario funcionario;
	
	@ManyToMany
	@JoinColumn(name = "productId", referencedColumnName = "id")
	List<Produto> produtos_retirados;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Produto> getProdutos_retirados() {
		return produtos_retirados;
	}

	public void setProdutos_retirados(List<Produto> produtos_retirados) {
		this.produtos_retirados = produtos_retirados;
	}

	public Saida(Date data_saida, Integer quantidade, String descricao, Funcionario funcionario) {
		super();
		this.funcionario = funcionario;
		this.data_saida = data_saida;
		this.quantidade = quantidade;
		this.descricao = descricao;
	}


	@Override
	public String toString() {
		return "Saida [id=" + id + ", data_saida=" + data_saida + ", quantidade=" + quantidade + ", descricao="
				+ descricao + ", funcionario=" + funcionario + ", produtos_retirados=" + produtos_retirados + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
