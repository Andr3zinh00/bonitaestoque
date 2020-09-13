package com.bonitaestoque.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

	private String senha;
	private String cpf;

	public Funcionario(String senha, String cpf, String login, String nome, String telefone, String email) {
		super(nome, telefone, email);
		this.senha = senha;
		this.cpf = cpf;
		this.login = login;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + Funcionario.super.getId() + ", senha=" + senha + ", cpf=" + cpf + ", login=" + login + "]";
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
