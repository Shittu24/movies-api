package com.shittu24.movies.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieService {
	
	private final MovieRepository movieRepository;

	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}
	
	public Optional<Movie> singleMovie(String imdbid) {
		return movieRepository.findMovieByImdbId(imdbid);
	}
}
