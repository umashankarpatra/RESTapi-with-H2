package com.xebia.linksharing.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xebia.linksharing.model.Link;

public interface LinkRepositoryJPA extends JPA {

	public List<Link> getDeactivateLink();

	public Page<Link> getAllLinks(final String tag, final Pageable pageable);
}
