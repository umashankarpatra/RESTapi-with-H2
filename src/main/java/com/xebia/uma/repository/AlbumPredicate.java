package com.xebia.uma.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.xebia.uma.model.Album;
import com.xebia.uma.model.Album_;

public class AlbumPredicate {

	public static Predicate[] getAlbumPredicates(CriteriaBuilder criteriaBuilder, Root<Album> root, String artist) {
		List<Predicate> predicates = new ArrayList<>();
		if (artist != null) {
			predicates.add(criteriaBuilder.equal(root.get(Album_.artist.getName()), artist));
		}
		return predicates.toArray(new Predicate[predicates.size()]);

	}

}
