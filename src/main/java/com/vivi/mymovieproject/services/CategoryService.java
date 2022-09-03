package com.vivi.mymovieproject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivi.mymovieproject.entities.Category;
import com.vivi.mymovieproject.repositories.CategoryRepository;
import com.vivi.mymovieproject.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> findAll() {
		return repo.findAll();
	}
	
	public Optional<Category> findById(Integer id) {
		Optional<Category> category=repo.findById(id);
		return category;
	}
	
	public Category insert(Category category) {
		return repo.save(category);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	public Category update(Integer id, Category category) {
		try {
			Category entity= repo.getById(id);
			updateData(entity, category);
			return repo.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Category entity, Category category) {
		entity.setName(category.getName());
	}
}
