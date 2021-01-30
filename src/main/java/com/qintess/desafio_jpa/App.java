package com.qintess.desafio_jpa;

//import java.util.GregorianCalendar;

import com.qintess.desafio_jpa.dao.AutoresDao;
import com.qintess.desafio_jpa.dao.EdicaoDao;
import com.qintess.desafio_jpa.dao.EditorasDao;
import com.qintess.desafio_jpa.dao.LivrosDao;
//import com.qintess.desafio_jpa.entidades.Autores;
//import com.qintess.desafio_jpa.entidades.Edicao;
//import com.qintess.desafio_jpa.entidades.Editoras;
//import com.qintess.desafio_jpa.entidades.Livros;

public class App {
	public static void main( String[] args ) {

		AutoresDao autoresService = new AutoresDao();
		EdicaoDao edicaoService = new EdicaoDao();
		EditorasDao editorasService = new EditorasDao();
		LivrosDao livrosService = new LivrosDao();
		
		System.out.println(livrosService.buscaPorNomeCompleta("Meu livrinho"));
		

	}
}

//Autores autorId = autoresService.buscaPorId(1);
//Autores autorId2 = autoresService.buscaPorId(2);
//Livros livroId = livrosService.buscaPorId(1);
//Livros livroId2 = livrosService.buscaPorId(2);
//Edicao edicaoId = edicaoService.buscaPorId(123);
//Edicao edicaoId2 = edicaoService.buscaPorId(456);
//Editoras editorasId = editorasService.buscaPorId(1);
//
//autorId.setDataNascimento(new GregorianCalendar(1996, 8, 22));
//autorId2.setDataNascimento(new GregorianCalendar(1987, 6, 15));
//autorId.setNacionalidade("Irlandês");
//autorId2.setNacionalidade("Maori");
//
//livroId.setAno(2014);
//livroId2.setAno(2000);
//livroId.setNome("Meu livrinho");
//livroId2.setNome("Seu livrinho");
//
//editorasId.setEndereco("Rua Palmito");
//editorasId.setNome("Editora Ômega");
//editorasId.setTelefone("99999999");
//
//edicaoId.setAno(2007);
//edicaoId.setCodigo_livro(1);
//edicaoId.setEditoras(editorasId);
//edicaoId.setEstoque(14);
//edicaoId.setId_editora(1);
//edicaoId.setLivro(livroId);
//edicaoId.setPaginas(400);
//edicaoId.setPreco(40.00);
//
//edicaoId2.setAno(2004);
//edicaoId2.setCodigo_livro(2);
//edicaoId2.setEditoras(editorasId);
//edicaoId2.setEstoque(89);
//edicaoId2.setId_editora(1);
//edicaoId2.setLivro(livroId2);
//edicaoId2.setPaginas(200);
//edicaoId2.setPreco(65.40);
//
//autoresService.update(autorId);
//autoresService.update(autorId2);
//livrosService.update(livroId);
//livrosService.update(livroId2);
//edicaoService.update(edicaoId);
//edicaoService.update(edicaoId2);
//editorasService.update(editorasId);
