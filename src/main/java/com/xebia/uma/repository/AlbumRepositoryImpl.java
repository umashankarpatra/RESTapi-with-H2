package com.xebia.uma.repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.xebia.uma.common.util.ImmutableCollectors;
import com.xebia.uma.model.Album;
import com.xebia.uma.model.Album_;
import com.xebia.uma.model.album.dto.AlbumResponse;

@Repository
public class AlbumRepositoryImpl extends AbstractJPA implements AlbumRepositoryJPA {

	@Override
	public Page<AlbumResponse> searchAlbums(final String artist, final Pageable pageable) {
		long totalRecords = findAlbumsCount(artist);
		if (totalRecords == 0) {
			return  new PageImpl<>(Collections.emptyList(), pageable, totalRecords);
		} else {
			CriteriaBuilder criteriaBuilder = criteriaBuilder();
			CriteriaQuery<Album> query = criteriaQuery(Album.class);
			Root<Album> rate = query.from(Album.class);
			if (!StringUtils.isEmpty(artist)) {
				//query.where(criteriaBuilder.equal(rate.get(Album_.artist.getName()), artist));
				query.where(AlbumPredicate.getAlbumPredicates(criteriaBuilder, rate, artist));
			}
			query.select(rate);
			query.distinct(true);
			query.orderBy(criteriaBuilder.asc(rate.get(Album_.title.getName())));
			TypedQuery<Album> typedQuery = typedQuery(query);

			typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			typedQuery.setMaxResults(pageable.getPageSize());
			List<Album> results = getUnmodifiableResultList(typedQuery);
			List<AlbumResponse> albumResponses = results.stream().map(AlbumResponse::of)
					.collect(ImmutableCollectors.toImmutableList());
			
			return  new PageImpl<>(albumResponses, pageable, totalRecords);
		}
	}

	private long findAlbumsCount(final String artist) {
		CriteriaBuilder criteriaBuilder = criteriaBuilder();
		CriteriaQuery<Long> query = criteriaQuery(Long.class);
		Root<Album> rate = query.from(Album.class);
		if (!StringUtils.isEmpty(artist)) {
			query.where(criteriaBuilder.equal(rate.get(Album_.artist.getName()), artist));
		}
		query.select(criteriaBuilder.countDistinct(rate));
		return typedQuery(query).getSingleResult().longValue();
	}

	@Override
	public String test() {

		return "uma";
	}
}
