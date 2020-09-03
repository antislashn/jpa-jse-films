package org.antislashn.films.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;

@Entity
@Subselect("SELECT f.pk_film,f.date_sortie,f.titre FROM films f")
public class FilmDTO {
	@Id
	@Column(name = "pk_film")
	Long id;
	@Column(name = "date_sortie")
	LocalDate dateSortie;
	String titre;

}
