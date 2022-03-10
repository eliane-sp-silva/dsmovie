package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository< Movie, Long> {
	//tipo da entidade e tipo do id
	//Jpa Repository já tem operações basicas CRUD
}



