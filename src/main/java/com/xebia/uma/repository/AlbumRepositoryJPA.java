package com.xebia.uma.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xebia.uma.model.album.dto.AlbumResponse;

public interface AlbumRepositoryJPA extends JPA {

	public Page<AlbumResponse> searchAlbums(final String artist, final Pageable pageable);
	
	public String test();
}

