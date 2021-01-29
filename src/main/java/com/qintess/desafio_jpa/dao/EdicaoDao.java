package com.qintess.desafio_jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.qintess.desafio_jpa.entidades.Edicao;


public class EdicaoDao {

	@PersistenceUnit
	EntityManagerFactory emf;

	public EdicaoDao() {

		emf = Persistence.createEntityManagerFactory("qintess");
	}

	public Edicao buscaPorId(Integer isbn) {

		Edicao ret = new Edicao();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.find(Edicao.class, isbn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void insere(Edicao edicao) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(edicao);
			em.getTransaction().commit();
			em.close();    

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void update(Edicao edicao) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(edicao);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void remove(Edicao edicao) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();

			edicao = em.merge(edicao);
			em.remove(edicao);

			em.getTransaction().commit();

			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Edicao> buscaTodos() {

		List<Edicao> edicoes = new ArrayList<Edicao>();

		try {

			EntityManager em = emf.createEntityManager();

			edicoes = em.createQuery("select e from Edicao e", Edicao.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return edicoes;
	}

	public Edicao buscaPorCodigoDoLivro(Integer codigo) {

		Edicao ret = new Edicao();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.createQuery("select e from Edicao e where e.codigo_livro = :codigo", Edicao.class)
					.setParameter("codigo", codigo)
					.setMaxResults(1)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

}
