package com.vivi.mymovieproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivi.mymovieproject.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
