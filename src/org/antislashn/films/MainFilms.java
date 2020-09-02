package org.antislashn.films;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.antislashn.films.dao.FilmDao;
import org.antislashn.films.dao.PersonneDao;
import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;

public class MainFilms {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("films");
		FilmDao filmDao = new FilmDao(emf);
		PersonneDao personneDao = new PersonneDao(emf);
		
		Film film1 = new Film("film1");
		Film film2 = new Film("film2");
		
		Personne a1 = new Personne("M", "One", "Joe");
		Personne a2 = new Personne("M", "Two", "Joe");
		
		film1.addActeur(a1);
		film1.addActeur(a2);
		film2.addActeur(a1);
		film2.addActeur(a2);
		
		filmDao.save(film1);
		filmDao.save(film2);
	}

}
