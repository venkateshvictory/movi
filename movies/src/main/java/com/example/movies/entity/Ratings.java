package com.example.movies.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Ratings {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@Column(name="TCONST")
	private Movies tconst;
	@Column(name="AVERAGE_RATING")
	private Double averageRating;
	@Column(name="Num_VOTES")
	private Integer numVotes;
	
	
}
