package org.antislashn.films;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.antislashn.films.dao.CategorieDAO;
import org.antislashn.films.dao.FilmDao;
import org.antislashn.films.dao.PersonneDao;
import org.antislashn.films.entities.Acteur;
import org.antislashn.films.entities.Categorie;
import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;

public class MainFilms {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("films");
		FilmDao filmDao = new FilmDao(emf);
		PersonneDao personneDao = new PersonneDao(emf);
		CategorieDAO catDao = new CategorieDAO(emf);
		
		Optional<Film> opt = filmDao.findById(2L);
		opt.ifPresent(f -> {
			System.out.printf("%s - réalisateur : %s %s\n", f.getTitre(),f.getRealisateur().getPrenom(),f.getRealisateur().getNom());
			f.getRoles().forEach((r,a) -> System.out.println(r.getLibelle()+ " : "+ a));
		});
		System.out.println("==============");
		Acteur a1 = personneDao.findActeurById(2L);
		Set<Film> films = filmDao.findByActeur(a1);
		films.forEach(f-> System.out.printf("%d : %s\n",f.getId(),f.getTitre()));
		
		
		
		emf.close();
		

	}

}
