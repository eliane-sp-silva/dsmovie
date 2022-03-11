package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

//registra como componente do sistema
@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		// preparando em memória o objeto score já com os tres dados
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		// metodo para salvar e retornar a referencia do objeto salvo
		score = scoreRepository.saveAndFlush(score);

		// dessa forma percorre a lista de scores e acumulando a soma de todos os
		// valores
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}

			double avg = sum / movie.getScores().size(); // avg = média

			// para salvar
			movie.setScore(avg);
			movie.setCount(movie.getScores().size());

			// para guardar
			movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}

}
