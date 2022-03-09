package com.devsuperior.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ScorePK implements Serializable{
	/**
	 * está pedindo um numero de versão 1l é o padrão.
	 */
	private static final long serialVersionUID = 1L;

	//serializable interface do java, indica que esse objeto pode ser convertido para bytes. JPA exige que a chave composta implemente serializable.
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie; //chave estrangeira
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; //chave estrangeira
	
	public ScorePK() {
		// TODO Auto-generated constructor stub
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
