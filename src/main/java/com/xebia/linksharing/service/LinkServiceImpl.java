package com.xebia.linksharing.service;

import static com.xebia.linksharing.common.util.ApplicationConstants.ONE;
import static com.xebia.linksharing.common.util.ExceptionConstants.DUPLICATE_URL_FOUND;
import static com.xebia.linksharing.common.util.ExceptionConstants.INVALID_URL_FOUND;
import static com.xebia.linksharing.common.util.ExceptionConstants.WEB_LINK_NOT_FOUND;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xebia.linksharing.common.exception.DuplicateUrlException;
import com.xebia.linksharing.common.exception.InvalidUrlException;
import com.xebia.linksharing.common.exception.WebLinkNotFoundException;
import com.xebia.linksharing.model.Link;
import com.xebia.linksharing.repository.LinkRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkRepository linkRepository;

	@Override
	@Transactional
	public Link submitWebLink(final Link link) {

		Link createdLink = null;
		if (validateURL(link.getUrl())) {
			Link exitUrl = this.linkRepository.findByUrl(link.getUrl());
			if (exitUrl != null) {
				throw new DuplicateUrlException(DUPLICATE_URL_FOUND + link.getUrl());
			}
			createdLink = this.linkRepository.save(link);
			log.debug("link" + createdLink);

		}
		return createdLink;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Link> getDeactivateLink() {
		return this.linkRepository.getDeactivateLink();

	}

	@Override
	@Transactional
	public boolean updateFavLink(final Long id) {
		Optional<Link> link = this.linkRepository.findById(id);
		if (!link.isPresent()) {
			throw new WebLinkNotFoundException(WEB_LINK_NOT_FOUND + id);
		}
		if (link.get().getFavCount() == null) {
			return false;

		}
		link.get().update(link.get().getFavCount() + ONE);
		this.linkRepository.flush();
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Link> getAllLinks(final String tag, final Pageable pageable) {
		return this.linkRepository.getAllLinks(tag, pageable);

	}

	private boolean validateURL(String url) {

		try {
			URL urlObj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			if ((responseCode > 400) || (responseCode > 500)) {
				throw new InvalidUrlException(INVALID_URL_FOUND + url);
			}

		} catch (Exception e) {
			throw new InvalidUrlException(INVALID_URL_FOUND + url);
		}
		return true;
	}

}
