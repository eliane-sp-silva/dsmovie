package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// tipo da entidade e tipo do id
	// Jpa Repository já tem operações basicas CRUD

	User findByEmail(String email);
}
