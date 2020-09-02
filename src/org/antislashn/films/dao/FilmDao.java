package org.antislashn.films.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;
import org.apache.derby.tools.sysinfo;

public class FilmDao extends AbstractDAO<Film, Long> {

	public FilmDao(EntityManagerFactory emf) {
		super(emf, Film.class);
	}
	
	public List<Personne> getActeursByFilm(Film film){
		System.out.println(film.getTitre());
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Film f = em.find(Film.class, film.getId());
		List<Personne> acteurs = new ArrayList<Personne>();
		if(f!=null) {
			// f.getActeurs(); // ATTENTION copie du proxy
			f.getActeurs().forEach(a->acteurs.add(a));
		}
		em.close();
		return acteurs;
	}

	public List<Personne> getActeursByFilmId(long id){
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Film f = em.find(Film.class, id);
		List<Personne> acteurs = new ArrayList<Personne>();
		if(f!=null) {
			// f.getActeurs(); // ATTENTION copie du proxy
			f.getActeurs().forEach(a->acteurs.add(a));
		}
		em.close();
		return acteurs;
	}

}
