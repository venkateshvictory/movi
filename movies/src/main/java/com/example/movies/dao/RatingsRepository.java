package com.example.movies.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.movies.dto.TopRatedMovieDto;
import com.example.movies.entity.Ratings;
@Repository("ratingRepository")
public interface RatingsRepository extends JpaRepository<Ratings, Long>{

	@Query("select new com.onito.Models.TopRatedMovieDTO(m.tconst,m.primaryTitle,m.genres,r.averageRating) from Movies m INNER JOIN Ratings r ON m.tconst = r.tconst where r.averageRating >= 6")
	List<TopRatedMovieDto> getTopRatedMovies();
}
