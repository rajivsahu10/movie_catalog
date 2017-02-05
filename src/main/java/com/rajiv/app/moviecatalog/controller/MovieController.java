package com.rajiv.app.moviecatalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rajiv.app.moviecatalog.exceptions.DuplicateMovieException;
import com.rajiv.app.moviecatalog.exceptions.MovieNotFoundException;
import com.rajiv.app.moviecatalog.model.Movie;
import com.rajiv.app.moviecatalog.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Movie getMovie(@RequestParam(value = "name") String name) {
		return movieService.getMovieByName(name);
	}
	
	@ExceptionHandler(MovieNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleMovieNotFoundException(MovieNotFoundException e) {
		return e.getMessage();
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieService.getAll(); 
		return movies;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Movie createMovie(@Valid @RequestBody Movie movie) {
		return movieService.createMovie(movie);
	}
	
	@ExceptionHandler(DuplicateMovieException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleDuplicateMovieCreation(DuplicateMovieException e) {
		return e.getMessage();
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public void deleteMovie(@PathVariable String id) {
		movieService.deleteMovie(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateMovie(@RequestBody Movie movie) {
		movieService.updateMovie(movie);
	}
}
