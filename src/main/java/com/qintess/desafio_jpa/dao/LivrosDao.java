package com.qintess.desafio_jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.qintess.desafio_jpa.entidades.Livros;

public class LivrosDao {

	@PersistenceUnit
	EntityManagerFactory emf;

	public LivrosDao() {

		emf = Persistence.createEntityManagerFactory("qintess");
	}

	public Livros buscaPorId(Integer id) {

		Livros ret = new Livros();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.find(Livros.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void insere(Livros livro) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
			em.close();    

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void update(Livros livro) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(livro);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void remove(Livros livro) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();

			livro = em.merge(livro);
			em.remove(livro);

			em.getTransaction().commit();

			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Livros> buscaTodos() {

		List<Livros> livros = new ArrayList<Livros>();

		try {

			EntityManager em = emf.createEntityManager();

			livros = em.createQuery("select p from Livros p", Livros.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return livros;
	}

	public Livros buscaPorNome(String nome) {

		Livros ret = new Livros();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.createQuery("select l from Livros l where l.nome = :nome", Livros.class)
					.setParameter("nome", nome)
					.setMaxResults(1)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	public Livros buscaPorNomeCompleta(String nome) {

		Livros ret = new Livros();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.createQuery("select l from Livros l where l.nome = :nome", Livros.class)
					.setParameter("nome", nome)
					.setMaxResults(1)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

}
