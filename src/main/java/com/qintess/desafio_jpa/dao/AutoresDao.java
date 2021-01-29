package com.qintess.desafio_jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.qintess.desafio_jpa.entidades.Autores;

public class AutoresDao {

	@PersistenceUnit
	EntityManagerFactory emf;

	public AutoresDao() {

		emf = Persistence.createEntityManagerFactory("qintess");
	}

	public Autores buscaPorId(Integer id) {

		Autores ret = new Autores();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.find(Autores.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void insere(Autores autor) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(autor);
			em.getTransaction().commit();
			em.close();    

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void update(Autores autor) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(autor);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List<Autores> buscaTodos() {

		List<Autores> autores = new ArrayList<Autores>();

		try {

			EntityManager em = emf.createEntityManager();

			autores = em.createQuery("select a from Autores a", Autores.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return autores;
	}

	public Autores buscaPorNome(String nome) {

		Autores ret = new Autores();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.createQuery("select a from Autores a where a.nome = :nome", Autores.class)
					.setParameter("nome", nome)
					.setMaxResults(1)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

}
