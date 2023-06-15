package com.example.movies.controller;

import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.dao.MoviesRepository;
import com.example.movies.dto.LongestDurationMovieDto;
import com.example.movies.entity.Movies;
import com.example.movies.entity.SumVotesDto;
import com.example.movies.service.MoviesService;

@RestController
//@RequestMapping("/movies")
public class MoviesController {

	@Resource(name = "moviesService")
	private MoviesService moviesService;

	@Resource(name = "moviesRepository")
	private MoviesRepository moviesRepository;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(path = "feedCustomerData")
	public void setDataInDB() {
		moviesService.saveMoviesData();
	}

	@PostMapping("/new-movie")
	public ResponseEntity<String> createNewMovie(@RequestBody Movies mv) {
		Movies movie = moviesService.createMovies(mv);
		String str = movie + " : movie successfully register ";
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

	// find top 10 longest duration movies
	@GetMapping("/longest-duration-movies")
	public ResponseEntity<List<Movies>> getTop10MoviesHandler() {
		List<Movies> top10MoviesList = moviesService.maxDurationMovies();

		return new ResponseEntity<List<Movies>>(top10MoviesList, HttpStatus.OK);
	}

	@GetMapping("/update-runtime-minutes")
	public ResponseEntity<List<Movies>> updateRuntimeHandler() {
		moviesService.getUpdatedRuntimeMovies();
		List<Movies> mvList = moviesRepository.findAll();

		return new ResponseEntity<List<Movies>>(mvList, HttpStatus.OK);
	}

	@GetMapping("/genre-movies-with-subtotals")
	public ResponseEntity<List<SumVotesDto>> getVotesHandler() {
		List<SumVotesDto> top10MoviesList = moviesService.calculateVotes();
		return new ResponseEntity<List<SumVotesDto>>(top10MoviesList, HttpStatus.OK);
	}

}
