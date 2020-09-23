package com.bonitaestoque.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tamanho_produto")
public class TamanhoProduto {

	@EmbeddedId
	private TamanhoProdutoId id;

	private Integer quantidade;

	public TamanhoProdutoId getId() {
		return id;
	}

	public void setId(TamanhoProdutoId id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(TamanhoProdutoId id, Integer quantidade) {
		this.id = id;
		this.quantidade = quantidade;
	}

	
	//Meu deus...
	@Embeddable
	public class TamanhoProdutoId implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long tamanho_id;
		private Long produto_id;

		public TamanhoProdutoId(Long tamanho_id, Long produto_id) {
			this.tamanho_id = tamanho_id;
			this.produto_id = produto_id;
		}

		public Long getTamanho_id() {
			return tamanho_id;
		}

		public void setTamanho_id(Long tamanho_id) {
			this.tamanho_id = tamanho_id;
		}

		public Long getProduto_id() {
			return produto_id;
		}

		public void setProduto_id(Long produto_id) {
			this.produto_id = produto_id;
		}

	}

	public TamanhoProduto(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
