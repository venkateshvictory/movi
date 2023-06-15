package com.example.movies.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.movies.Exception.MovieExceptions;
import com.example.movies.Exception.RatingExceptions;
import com.example.movies.dao.MoviesRepository;
import com.example.movies.dto.LongestDurationMovieDto;
import com.example.movies.entity.Movies;
import com.example.movies.entity.SumVotesDto;

@Service
public class MoviesService {

	@Resource(name = "moviesRepository")
	private MoviesRepository moviesRepository;

	String line = "";

	public void saveMoviesData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/movies.csv"));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Movies m = new Movies();
				m.setGenres(data[4]);
				m.setPrimaryTitle(data[2]);
				m.setRuntimeMinutes(data[3]);
				m.setTconst(data[1]);
				m.setTitleType(data[1]);
				moviesRepository.save(m);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Movies createMovies(Movies movie) {

		Optional<Movies> opt = moviesRepository.findByTconst(movie.getTconst());
		if (opt.isEmpty()) {
			return moviesRepository.save(movie);
		} else {

			throw new MovieExceptions("movie already exits with the name of : " + movie.getTconst());
		}
	}

	public List<Movies> maxDurationMovies() throws MovieExceptions {
		List<Movies> movieDTOList = moviesRepository.getLongestRuntimeMovies();
		return movieDTOList;
	}

	public void getUpdatedRuntimeMovies() throws MovieExceptions, RatingExceptions {
		moviesRepository.updateRuntimeMinutes();

	}

	
	  public List<SumVotesDto> calculateVotes() throws MovieExceptions,
	  RatingExceptions { List<SumVotesDto> votes = moviesRepository.findAllvotes();
	  return votes; }
	 

}
