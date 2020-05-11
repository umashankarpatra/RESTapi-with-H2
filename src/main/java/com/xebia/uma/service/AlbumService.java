package com.xebia.uma.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xebia.uma.model.album.dto.AlbumResponse;
import com.xebia.uma.model.album.dto.CreateAlbumRequest;

public interface AlbumService {

	public Page<AlbumResponse> getAlbums(String artist, Pageable pageable);

	public Optional<AlbumResponse> getAlbumsById(final long id);

	public Boolean updateAlbumDescription(final Long albumId, final String description);
	
	public void cretaeAlbum(final CreateAlbumRequest createRequest);
}
