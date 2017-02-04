package com.rajiv.app.moviecatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rajiv.app.moviecatalog.model.Movie;
import com.rajiv.app.moviecatalog.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Movie getMovie(@RequestParam(value = "name") String name) {
		return movieRepository.findByName(name);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieRepository.findAll(); 
		return movies;
	}

	@RequestMapping(method = RequestMethod.POST)	
	public Movie createMovie(@RequestBody Movie movie) {
		return movieRepository.insert(movie);
	}
}
