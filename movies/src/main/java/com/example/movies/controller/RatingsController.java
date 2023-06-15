package com.example.movies.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movies.dto.TopRatedMovieDto;
import com.example.movies.service.RatingService;

public class RatingsController {

	@Resource(name = "ratingsService")
	private RatingService ratingService;

	// getting top ratted movies

	@GetMapping("/top-rated-movies")
	public ResponseEntity<List<TopRatedMovieDto>> getTop10MoviesHandler() {
		List<TopRatedMovieDto> top10MoviesList = ratingService.findTopRatedMovies();
		// getting movies list System.out.println(top10MoviesList);
		return new ResponseEntity<List<TopRatedMovieDto>>(top10MoviesList, HttpStatus.OK);

	}

}
