package org.antislashn.films.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;

public class FilmDao extends AbstractDAO<Film, Long> {

	public FilmDao(EntityManagerFactory emf) {
		super(emf, Film.class);
	}
	
	public void save(Film film) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		for(Personne a : film.getActeurs()) {
			if(a.getId()==null)
				em.persist(a);
			else
				em.merge(a);
		}
		em.persist(film);
		em.getTransaction().commit();
		em.close();
	}

}
