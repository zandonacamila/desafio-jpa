package com.qintess.desafio_jpa.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Edicao {

	@Id
	private Integer isbn;
	
	@Column(precision = 3, scale = 2)
	private Double preco;
	private Integer ano;
	private Integer paginas;
	
	@Column(length = 45)
	private Integer estoque;
	
	private Integer codigo_livro;
	private Integer id_editora;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Livros livro;
	
	@ManyToOne
	private Editoras editoras;
	
	public Edicao() {}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Integer getCodigo_livro() {
		return codigo_livro;
	}

	public void setCodigo_livro(Integer codigo_livro) {
		this.codigo_livro = codigo_livro;
	}

	public Integer getId_editora() {
		return id_editora;
	}

	public void setId_editora(Integer id_editora) {
		this.id_editora = id_editora;
	}

	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro;
	}

	public Editoras getEditoras() {
		return editoras;
	}

	public void setEditoras(Editoras editoras) {
		this.editoras = editoras;
	}

	@Override
	public String toString() {
		return "Edicao [isbn=" + isbn + ", preco=" + preco + ", ano=" + ano + ", paginas=" + paginas + ", estoque="
				+ estoque + ", codigo_livro=" + codigo_livro + ", id_editora=" + id_editora + ", livro=" + livro
				+ ", editoras=" + editoras + "]";
	}
	
}
