package org.antislashn.films.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "roles")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of= {"id"})

@Entity
@Table(name = "films")
@SecondaryTable(name="resumes",pkJoinColumns=@PrimaryKeyJoinColumn(name="fk_film"))

@NamedQuery(name = "Film.findByCategorie",
				query = "SELECT f FROM Film f WHERE f.categorie = :categorie")
@NamedQuery(name = "Film.findByCategorieLibelle",
				query = "SELECT f FROM Film f WHERE f.categorie.libelle = :libelle")
@NamedQuery(name = "Film.findByActeur",
					query = "SELECT f FROM Film f JOIN f.roles r WHERE :acteur IN (VALUE(r))")
public class Film implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_film")
	Long id;
	String titre;
	@Column(name = "date_sortie")
	LocalDate dateSortie;
	int duree;
	@Column(name = "prixht")
	double prixHT;
	@Column(table = "resumes")
	String resume;
	@ManyToOne
	@JoinColumn(name = "fk_categorie")
	Categorie categorie;
	@ManyToOne
	@JoinColumn(name = "fk_realisateur")
	Realisateur realisateur;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "film_acteur", 
		joinColumns = @JoinColumn(name = "fk_film"), 
		inverseJoinColumns = @JoinColumn(name = "fk_acteur"))
	private Map<Role, Acteur> roles = new HashMap<Role, Acteur>();
	
	public Film(String titre) {
		this.titre = titre;
	}
	
	public void addActeur(Acteur acteur, Role role) {
		roles.put(role, acteur);
	}

}
