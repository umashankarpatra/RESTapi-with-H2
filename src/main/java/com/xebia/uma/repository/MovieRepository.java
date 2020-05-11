package com.xebia.uma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xebia.uma.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryJPA {

}
