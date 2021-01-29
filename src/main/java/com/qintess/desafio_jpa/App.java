package com.qintess.desafio_jpa;

import java.util.Arrays;

import com.qintess.desafio_jpa.dao.AutoresDao;
import com.qintess.desafio_jpa.dao.EdicaoDao;
import com.qintess.desafio_jpa.dao.EditorasDao;
import com.qintess.desafio_jpa.dao.LivrosDao;
import com.qintess.desafio_jpa.entidades.Autores;
import com.qintess.desafio_jpa.entidades.Edicao;
import com.qintess.desafio_jpa.entidades.Editoras;
import com.qintess.desafio_jpa.entidades.Livros;

public class App {
    public static void main( String[] args ) {
        
        Autores autor = new Autores();
        Edicao edicao = new Edicao();
        Editoras editoras = new Editoras();
        Livros livro = new Livros();
        
        AutoresDao autoresService = new AutoresDao();
        EdicaoDao edicaoService = new EdicaoDao();
        EditorasDao editorasService = new EditorasDao();
        LivrosDao livrosService = new LivrosDao();

        autoresService.insere(autor);
        livrosService.insere(livro);
        
        Autores autorzinho = autoresService.buscaPorId(1);
        Livros livrinho = livrosService.buscaPorId(1);
        
        autorzinho.setNome("Frederico Roberto");
        autorzinho.setBiografia("No meio do caminho havia uma pedra.");
        autorzinho.getLivros().add(livrinho);
        
        autoresService.update(autorzinho);
        
    }
}
