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
		
		Optional<Film> opt1 = filmDao.findById(1L);
		opt1.ifPresent(f->{
			f.getActeurs().forEach(System.out::println);
		});
		
		
//		Optional<Personne> opt2 = personneDao.findById(1L);
//		opt2.ifPresent(System.out::println);
//		emf.close();
	}

}
