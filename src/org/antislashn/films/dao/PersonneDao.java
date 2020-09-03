package org.antislashn.films.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.films.entities.Acteur;
import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;

public class PersonneDao extends AbstractDAO<Personne, Long> {

	public PersonneDao(EntityManagerFactory emf) {
		super(emf, Personne.class);
	}

	public Acteur findActeurById(long id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Acteur acteur = em.find(Acteur.class, id);
		em.close();
		return acteur;
	}
}
