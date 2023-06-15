package com.example.movies.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.movies.dto.LongestDurationMovieDto;
import com.example.movies.entity.Movies;
import com.example.movies.entity.SumVotesDto;

@Repository("moviesRepository")
public interface MoviesRepository extends JpaRepository<Movies, Long> {

	Optional<Movies> findByTconst(String tconst);

	// top 10 movie with logest runtime duration

	@Query(value = "SELECT m.id,m.TITELE_TYPE,m.tconst,m.PRIMARY_TITLE,m.RUN_TIME_MINUTES,m.genres from Movies m order by RUN_TIME_MINUTES DESC LIMIT 10", nativeQuery = true)
	List<Movies> getLongestRuntimeMovies();

	@Modifying

	@Transactional

	@Query(value = "Update Movies set RUN_TIME_MINUTES = CASE WHEN genres = 'Documentary' THEN RUN_TIME_MINUTES+15 WHEN genres = 'Animation' THEN RUN_TIME_MINUTES+30 ELSE RUN_TIME_MINUTES+45 END", nativeQuery = true)
	void updateRuntimeMinutes();

@Query("select SumVotesDto(m.genres,m.primaryTitle,SUM(r.numVotes)) from Movies m INNER JOIN Ratings r ON m.tconst = r.tconst group by m.primaryTitle")
List<SumVotesDto> findAllvotes();
}
