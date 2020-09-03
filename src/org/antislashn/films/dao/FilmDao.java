package org.antislashn.films.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.films.dto.FilmDTO;
import org.antislashn.films.entities.Acteur;
import org.antislashn.films.entities.Categorie;
import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;


public class FilmDao extends AbstractDAO<Film, Long> {

	public FilmDao(EntityManagerFactory emf) {
		super(emf, Film.class);
	}
	
	public List<Film> findAll(){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String jpql = "SELECT f FROM Film";
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
	
	public Set<Film> findByActeur(Acteur acteur){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Set<Film> films = em.createNamedQuery("Film.findByActeur", Film.class)
							.setParameter("acteur", acteur)
							.getResultStream().collect(Collectors.toSet());
		em.close();
		return films;
	}
	
	public List<FilmDTO> findAllDTO(){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		String jpql = "SELECT f FROM FilmDTO";
		List<FilmDTO> films = em.createQuery(jpql, FilmDTO.class)
							.getResultList();
		em.close();
		return films;
	}

}
