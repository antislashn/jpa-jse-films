package org.antislashn.films.service;

import java.util.Optional;

import org.antislashn.films.dao.FilmDao;
import org.antislashn.films.dto.FilmDto;

public class FilmService {
	private FilmDao dao;

	public FilmService(FilmDao dao) {
		this.dao = dao;
	}
	
	Optional<FilmDto> findFilmDtoById(long id){
		return Optional.ofNullable(null);
	}
	

}
