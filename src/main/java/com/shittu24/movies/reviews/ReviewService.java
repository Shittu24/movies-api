package com.shittu24.movies.reviews;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.shittu24.movies.movie.Movie;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;
	
	private final MongoTemplate mongoTemplate;
	
	public Reviews createReview(String reviewBody, String imdbid) {
		Reviews review = reviewRepository.insert(
				new Reviews(reviewBody));
		
		mongoTemplate.update(Movie.class)
        .matching(Criteria.where("imdbId").is(imdbid))
        .apply(new Update().push("reviewIds").value(review))
        .first();
		
		return review;
		
	}
}
