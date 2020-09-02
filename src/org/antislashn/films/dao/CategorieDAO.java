package org.antislashn.films.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.films.entities.Categorie;
import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;


public class CategorieDAO extends AbstractDAO<Categorie, Long> {

	public CategorieDAO(EntityManagerFactory emf) {
		super(emf, Categorie.class);
	}
	
	public List<Categorie> findAll(){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String jpql = "SELECT f FROM Categorie";
		List<Categorie> films = em.createQuery(jpql, Categorie.class)
							.getResultList();
		em.close();
		return films;
	}

}
