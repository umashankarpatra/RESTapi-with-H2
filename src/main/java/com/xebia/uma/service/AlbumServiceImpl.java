package com.xebia.uma.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xebia.uma.common.exception.ResourceNotFoundException;
import com.xebia.uma.model.Album;
import com.xebia.uma.model.Movie;
import com.xebia.uma.model.album.dto.AlbumResponse;
import com.xebia.uma.model.album.dto.CreateAlbumRequest;
import com.xebia.uma.repository.AlbumRepository;
import com.xebia.uma.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired

	private MovieRepository movieRepository;

	@Override
	public Page<AlbumResponse> getAlbums(String artist, Pageable pageable) {
		System.out.println("Hello");
		// movieRepository.getAllMovies();

		// createMovies();
		return albumRepository.searchAlbums(artist, pageable);
	}

	public String m1(String name) {
		return albumRepository.test();
	}

	@Transactional
	public void createMovies() throws ResourceNotFoundException {

		Movie movie = new Movie();
		movie.setArtist("umashankar");
		movie.setDescription("Boolywood actor");
		movie.setReleaseDate("12/34/55");
		movie.setTitle("pyar nahi hua");

		Long employeeId = (long) 100;
		Optional<Movie> movieById = movieRepository.findById((long) 100);

		if (!movieById.isPresent()) {
			throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		}

		log.debug("---->>>>Movie By ID" + movieById);
		// movie = movieRepository.save(movie);

		// log.debug("--->>>>creted movie :: " + movie);

	}

	@Override
	// @Transactional(readOnly = true)
	public Optional<AlbumResponse> getAlbumsById(final long id) {

		System.out.println("--->>>" + updateAlbumDescription(id));
		Optional<AlbumResponse> response = albumRepository.findById(id).map(AlbumResponse::of);
		if (!response.isPresent()) {
			throw new ResourceNotFoundException("Album not found for this id :: " + id);
		}
		return response;
	}

	@Transactional
	public Boolean updateAlbumDescription(final long id) {
		Optional<Album> album = albumRepository.findById(id);
		if (!album.isPresent()) {
			throw new ResourceNotFoundException("Album not found for this id :: " + id);
		}
		if (album.get().getDescription() == "test") {
			return false;
		}
		album.get().updateDescription("i ma good ");
		this.albumRepository.saveAndFlush(album.get());
		return true;

	}

	@Override
	@Transactional
	public Boolean updateAlbumDescription(final Long albumId, final String description) {

		Optional<Album> album = albumRepository.findById(albumId);
		if (!album.isPresent()) {
			throw new ResourceNotFoundException("Album not found for this id :: " + albumId);
		}
		if (album.get().getDescription() == description) {
			return false;
		}
		album.get().updateDescription(description);
		this.albumRepository.saveAndFlush(album.get());
		return true;
	}

	@Override
	@Transactional
	public void cretaeAlbum(CreateAlbumRequest createRequest) {
		// TODO Auto-generated method stub

		Album album = new Album();
		album.setArtist(createRequest.getArtist());
		album.setDescription(createRequest.getDescription());
		album.setReleaseDate(createRequest.getReleaseDate());
		album.setTitle(createRequest.getTitle());

		Album createAlbum = this.albumRepository.save(album);

		System.out.println("Create Album" + createAlbum);
	}

}
