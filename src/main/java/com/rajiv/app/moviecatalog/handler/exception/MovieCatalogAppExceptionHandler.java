package com.rajiv.app.moviecatalog.handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rajiv.app.moviecatalog.exceptions.DuplicateMovieException;
import com.rajiv.app.moviecatalog.exceptions.MovieNotFoundException;

@ControllerAdvice
@RestController
public class MovieCatalogAppExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		return e.getMessage();
	}
	
	
}
