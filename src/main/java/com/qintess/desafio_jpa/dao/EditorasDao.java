package com.qintess.desafio_jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.qintess.desafio_jpa.entidades.Editoras;


public class EditorasDao {

	@PersistenceUnit
	EntityManagerFactory emf;

	public EditorasDao() {

		emf = Persistence.createEntityManagerFactory("qintess");
	}

	public Editoras buscaPorId(Integer id) {

		Editoras ret = new Editoras();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.find(Editoras.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void insere(Editoras editora) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(editora);
			em.getTransaction().commit();
			em.close();    

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void update(Editoras editora) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(editora);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void remove(Editoras editora) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();

			editora = em.merge(editora);
			em.remove(editora);

			em.getTransaction().commit();

			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Editoras> buscaTodos() {

		List<Editoras> editoras = new ArrayList<Editoras>();

		try {

			EntityManager em = emf.createEntityManager();

			editoras = em.createQuery("select e from Editoras e", Editoras.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return editoras;
	}

	public Editoras buscaPorNome(String nome) {

		Editoras ret = new Editoras();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.createQuery("select e from Editoras e where e.nome = :nome", Editoras.class)
					.setParameter("nome", nome)
					.setMaxResults(1)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

}
