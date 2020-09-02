package org.antislashn.films.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import org.antislashn.films.entities.Personne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class FilmDto {
	Long id;
	String titre;
	LocalDate dateSortie;
	int duree;
	double prixHT;
}
