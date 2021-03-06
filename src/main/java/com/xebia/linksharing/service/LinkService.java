package com.xebia.linksharing.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xebia.linksharing.model.Link;

public interface LinkService {

	public Link submitWebLink(final Link link);
	
	public List<Link> getDeactivateLink();
	
	public boolean updateFavLink(final Long id);
	
	public Page<Link> getAllLinks(final String tag,final Pageable pageable);
}
