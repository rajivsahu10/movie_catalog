package com.rajiv.app.moviecatalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="movies")
public class Movie {

	@Id
	private String id;
	private String name;

	public Movie(String name) {
		this.name = name;
	}
	
	public Movie() {
		
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
