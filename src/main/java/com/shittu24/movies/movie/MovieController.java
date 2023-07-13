package com.shittu24.movies.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	private final MovieService movieService;

	@GetMapping
	public ResponseEntity<List<Movie>> retrieveMovies() {
		return new ResponseEntity<List<Movie>>(
				movieService.allMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/{imdbid}")
	public ResponseEntity<Optional<Movie>> retrieveSingleMovie(
				@PathVariable String imdbid) {
		return new ResponseEntity<Optional<Movie>>(
				movieService.singleMovie(imdbid), HttpStatus.OK);
	}
}
