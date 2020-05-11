package com.xebia.uma.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.xebia.uma.model.Movie;
import com.xebia.uma.model.Movie_;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MovieRepositoryImpl extends AbstractJPA implements MovieRepositoryJPA {

	@Override
	public void getAllMovies() {
		long totalRecords = findAllMoviesCount();
		log.info("-------->>>>>" + totalRecords);
		if (totalRecords == 0) {
			log.info("totalRecords" + totalRecords);
		}

		else {
			CriteriaBuilder criteriaBuilder = criteriaBuilder();
			CriteriaQuery<Movie> query = criteriaQuery(Movie.class);
			Root<Movie> rate = query.from(Movie.class);
			query.select(rate);
			//criteriaBuilder.asc(rate.get("artist"));
			query.orderBy(criteriaBuilder.asc(rate.get(Movie_.ARTIST)));
			
			List<Long> ids=new ArrayList<Long>();
			ids.add(Long.valueOf(12));
			ids.add(Long.valueOf(13));
			
			/*
			 * query.where(criteriaBuilder.or(criteriaBuilder.equal(rate.get(Movie_.artist.
			 * getName()), "Himesh"),
			 * criteriaBuilder.equal(rate.get(Movie_.releaseDate.getName()),
			 * "10-03-1990")));
			 */
			
			//query.where(criteriaBuilder.Movie.get(Movie_.id.getName()).in(ids)));
			
			 query.where(
					 rate.get(Movie_.id.getName()).in(ids));
			
			//query.where(getMoviePredicates(criteriaBuilder,rate,"Himesh","10-03-1990"));
			
			TypedQuery<Movie> typedQuery = typedQuery(query);
			List<Movie> results = getUnmodifiableResultList(typedQuery);
			System.out.println("---->>>>>>");
			results.forEach(System.out::println);

		}

	}

	private long findAllMoviesCount() {

		CriteriaBuilder criteriaBuilder = criteriaBuilder();
		CriteriaQuery<Long> query = criteriaQuery(Long.class);
		Root<Movie> rate = query.from(Movie.class);
		query.select(criteriaBuilder.countDistinct(rate));
		return typedQuery(query).getSingleResult().longValue();
	}
	
	public Predicate[] getMoviePredicates(CriteriaBuilder criteriaBuilder,Root<Movie> root,String artist,String date){
		List<Predicate> predicates = new ArrayList<>();
		/*
		 * if(artist !=null) {
		 * predicates.add(criteriaBuilder.equal(root.get(Movie_.artist.getName()),
		 * "Himesh")); }
		 */
		if(date!=null && artist !=null) {
			predicates.add(criteriaBuilder.or(criteriaBuilder.equal(root.get(Movie_.releaseDate.getName()), "10-03-1990"),
					criteriaBuilder.equal(root.get(Movie_.artist.getName()), "Himesh")));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
		
	}

}
