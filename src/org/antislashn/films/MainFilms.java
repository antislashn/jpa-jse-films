package org.antislashn.films;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.antislashn.films.dao.CategorieDAO;
import org.antislashn.films.dao.FilmDao;
import org.antislashn.films.dao.PersonneDao;
import org.antislashn.films.entities.Categorie;
import org.antislashn.films.entities.Film;
import org.antislashn.films.entities.Personne;

public class MainFilms {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("films");
		FilmDao filmDao = new FilmDao(emf);
		PersonneDao personneDao = new PersonneDao(emf);
		CategorieDAO catDao = new CategorieDAO(emf);
		
//		List<Film> films = filmDao.findByCategorie("anticipation");
//		films.forEach(f -> System.out.println(f.getTitre()+" - "+f.getCategorie().getLibelle()));
//		System.out.println("====================");
//		Optional<Categorie> opt = catDao.findById(2L);
//		opt.ifPresent(c -> {
//			List<Film> liste = filmDao.findByCategorie(c);
//			liste.forEach(f -> System.out.println(f.getTitre()+" - "+f.getCategorie().getLibelle()));
//		});
//		
		Optional<Personne> p1 = personneDao.findById(1L);
		p1.ifPresent(p -> {
			List<Film> films = filmDao.findByActeur(p);
			films.forEach(f -> System.out.println(f.getTitre()+" - "+f.getCategorie().getLibelle()));
		});
		
//		Optional<Film> opt = filmDao.findById(1L);
//		
//		opt.ifPresent(f->{
//			System.out.println(f.getTitre()+" - "+f.getCategorie().getLibelle());
//			f.getRoles().forEach((r,a)->System.out.println(r.getLibelle()+" : "+a));
//		});
//		Film film1 = new Film("film1");
//		Film film2 = new Film("film2");
//		
//		Personne a1 = new Personne("M", "One", "Joe");
//		Personne a2 = new Personne("M", "Two", "Joe");
//		
//		film1.addActeur(a1);
//		film1.addActeur(a2);
//		film2.addActeur(a1);
//		film2.addActeur(a2);
//		
//		a1.addFilm(film1);
//		a1.addFilm(film2);
//		
//		a2.addFilm(film1);
//		a2.addFilm(film2);
		
//		filmDao.save(film1);
//		filmDao.save(film2);
		

	}

}
