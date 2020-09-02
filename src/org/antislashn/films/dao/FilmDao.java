package org.antislashn.films.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.films.entities.Categorie;
import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;


public class FilmDao extends AbstractDAO<Film, Long> {

	public FilmDao(EntityManagerFactory emf) {
		super(emf, Film.class);
	}
	
	public List<Film> findAll(){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String jpql = "SELECT f FROM film";
		List<Film> films = em.createQuery(jpql, Film.class)
							.getResultList();
		em.close();
		return films;
	}
	
	public List<Film> findByCategorie(Categorie categorie){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<Film> films = em.createNamedQuery("Film.findByCategorie", Film.class)
							.setParameter("categorie", categorie)
							.getResultList();
		em.close();
		return films;
	}
	
	public List<Film> findByCategorie(String categorie){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<Film> films = em.createNamedQuery("Film.findByCategorieLibelle", Film.class)
							.setParameter("libelle", categorie)
							.getResultList();
		em.close();
		return films;
	}

}
