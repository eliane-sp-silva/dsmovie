package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {
//Essa classe Score é de associação, tem que ter uma referencia para o Movie e outra para User e um terceiro atributo "value".
//No JPA, o identificador de cada classe tem que ser só um atributo, nesse caso de chave composta, 
//precisa criar uma classe auxiliar para ter as duas referencias. 

	@EmbeddedId
	private ScorePK id = new ScorePK();
	private Double value;

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public void setMovie(Movie movie) {
		id.setMovie(movie); // Para associar o movie com o score.
	}

	public void setUser(User user) {
		id.setUser(user); // Para associar o user com o score.
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
