package com.rajiv.app.moviecatalog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rajiv.app.moviecatalog.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, String>{

	public Movie findByName(String name);
	public List<Movie> findAll();
} 
