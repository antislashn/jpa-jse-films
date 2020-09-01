package org.antislashn.films.dao;

import javax.persistence.EntityManagerFactory;

import org.antislashn.films.entities.Film;

public class FilmDao extends AbstractDAO<Film, Long> {

	public FilmDao(EntityManagerFactory emf) {
		super(emf, Film.class);
	}

}
