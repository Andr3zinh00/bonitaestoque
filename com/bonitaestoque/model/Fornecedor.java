package com.bonitaestoque.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa {

	private String cnpj;
	

	public Fornecedor(String nome, String telefone, String email, Long id, String cnpj) {
		super(nome, telefone, email);
		this.cnpj = cnpj;
	}

	public Fornecedor(String nome, String telefone, String email) {
		super(nome, telefone, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + Fornecedor.super.getId()+ ", cnpj=" + cnpj + "]";
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
