package com.qintess.desafio_jpa.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Livros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(length = 45)
	private String nome;
	
	@Column(length = 15)
	private String idioma;
	private Integer ano;
	
	@ManyToMany
	private List<Autores> autor = new ArrayList<Autores>();
	
	@OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
	private List<Edicao> edicao = new ArrayList<Edicao>();
	
	public Livros() {}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<Autores> getAutor() {
		return autor;
	}

	public void setAutor(List<Autores> autor) {
		this.autor = autor;
	}

	public List<Edicao> getEdicao() {
		return edicao;
	}

	public void setEdicao(List<Edicao> edicao) {
		this.edicao = edicao;
	}

	@Override
	public String toString() {
		return "Livros [codigo=" + codigo + ", nome=" + nome + ", idioma=" + idioma + ", ano=" + ano + ", autor="
				+ autor + ", edicao=" + edicao + "]";
	}
	
}
