package com.vivi.mymovieproject.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.vivi.mymovieproject.entities.Category;
import com.vivi.mymovieproject.services.CategoryService;

@RequestMapping(value="/categories")
@RestController
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> categories=service.findAll();
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<Category>> findById(@PathVariable Integer id){
		Optional<Category> category=service.findById(id);
		return ResponseEntity.ok().body(category);
	}
	
	@PostMapping(value="/{id}")
	public ResponseEntity<Category> insert(@RequestBody Category category){
		category=service.insert(category);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).body(category);
	}
	
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category){
		category=service.update(id, category);
		return ResponseEntity.ok().body(category);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Category> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
