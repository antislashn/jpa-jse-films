package org.antislashn.films.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "acteurs")
@FieldDefaults(level = AccessLevel.PRIVATE)


@Entity
@Table(name="films")
public class Film implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_film")
	Long id;
	String titre;
	@Column(name="date_sortie")
	LocalDate dateSortie;
	int duree;
	@Column(name="prixht")
	double prixHT;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "film")
	List<Personne> acteurs;

}
