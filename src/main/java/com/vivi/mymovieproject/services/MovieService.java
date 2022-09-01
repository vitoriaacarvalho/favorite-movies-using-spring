package com.vivi.mymovieproject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vivi.mymovieproject.entities.Movie;
import com.vivi.mymovieproject.repositories.MovieRepository;
import com.vivi.mymovieproject.resources.exceptions.DatabaseException;
import com.vivi.mymovieproject.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repo;
	
	public Movie findById(Integer id) {
		Optional<Movie> movie=repo.findById(id);
		return movie.get();
	}
	
	public List<Movie> findAll(){
		return repo.findAll();
	}
	
	public Movie insert(Movie movie) {
		return repo.save(movie);
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Movie update(Integer id, Movie movie) {
		try {
			Movie entity=repo.getById(id);
			updateData(entity, movie);
			return repo.save(entity);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
			
		}
	}
	private void updateData(Movie entity, Movie obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setYear(obj.getYear());
	}
	
	
	
	
	
	
	
	
}
