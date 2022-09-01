package com.vivi.mymovieproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivi.mymovieproject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
