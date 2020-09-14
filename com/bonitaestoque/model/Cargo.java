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
@Table(name="cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@ManyToMany
	@JoinColumn(name = "id")
	List<Funcionario> func_list;

	public Cargo(String nome, List<Funcionario> func_list) {
		super();
		this.nome = nome;
		this.func_list = func_list;
	}

	public List<Funcionario> getFunc_list() {
		return func_list;
	}

	public void setFunc_list(List<Funcionario> func_list) {
		this.func_list = func_list;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + ", func_list=" + func_list + "]";
	}

	public Cargo(String nome) {
		super();
		this.nome = nome;
	}
}
