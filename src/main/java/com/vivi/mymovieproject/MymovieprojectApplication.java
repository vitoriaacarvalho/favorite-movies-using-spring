package com.vivi.mymovieproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.vivi.mymovieproject.entities.Category;
import com.vivi.mymovieproject.entities.Movie;
import com.vivi.mymovieproject.repositories.CategoryRepository;
import com.vivi.mymovieproject.repositories.MovieRepository;

@Configuration
@SpringBootApplication
public class MymovieprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MymovieprojectApplication.class, args);
		
		
	}

	@Autowired
	private CategoryRepository cr;
	
	@Autowired 
	private MovieRepository mr;
	
	@Override
	public void run(String... args) throws Exception {
		Category c1=new Category("horror",null);
		Category c2=new Category("romance",null);
		Category c3=new Category("documentary",null);
		Category c4=new Category("drama",null);
		
		cr.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		Movie m1=new Movie("la la land", "o mais triste do mundo", 2016, null);
		
		mr.saveAll(Arrays.asList(m1));
		
		
		
		
		
		
		
	};
	

}
