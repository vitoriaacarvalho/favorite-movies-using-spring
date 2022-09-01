package com.vivi.mymovieproject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vivi.mymovieproject.entities.Movie;
import com.vivi.mymovieproject.services.MovieService;

@RestController
@RequestMapping(value="/products")
public class MovieResource {
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<List<Movie>> findAll(){
		List<Movie> movies=service.findAll();
		return ResponseEntity.ok().body(movies);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Movie> findById(@PathVariable Integer id){
		Movie movie=service.findById(id);
		return ResponseEntity.ok().body(movie);
	}
	
	@PostMapping
	public ResponseEntity<Movie> insert(@RequestBody Movie movie){
		movie=service.insert(movie);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(movie.getId()).toUri();
		return ResponseEntity.created(uri).body(movie);	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Movie> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Movie> update(@PathVariable Integer id, @RequestBody Movie movie){
		movie=service.update(id,movie);
		return ResponseEntity.ok().body(movie);
	}
}
