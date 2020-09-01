package org.antislashn.films.dao;

import javax.persistence.EntityManagerFactory;

import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;

public class PersonneDao extends AbstractDAO<Personne, Long> {

	public PersonneDao(EntityManagerFactory emf) {
		super(emf, Personne.class);
	}

}
