package com.example.movies.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.movies.Exception.MovieExceptions;
import com.example.movies.Exception.RatingExceptions;
import com.example.movies.dao.RatingsRepository;
import com.example.movies.dto.TopRatedMovieDto;

@Service("ratingService")
public class RatingService {

            @Resource(name="ratingRepository")
            private RatingsRepository ratingsRepository;

	public List<TopRatedMovieDto> findTopRatedMovies() throws MovieExceptions, RatingExceptions {
		List<TopRatedMovieDto>topRatedMoviesList = ratingsRepository.getTopRatedMovies();
		return topRatedMoviesList;
	}
}
