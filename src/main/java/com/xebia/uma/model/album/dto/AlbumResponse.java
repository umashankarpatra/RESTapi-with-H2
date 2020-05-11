package com.xebia.uma.model.album.dto;

import java.util.Date;

import com.xebia.uma.model.Album;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class AlbumResponse {

	private Long id;

	private String title;

	private String description;

	private String artist;

	private Date releaseDate;

	public static AlbumResponse of(Album album) {
		return new AlbumResponse(album.getId(), album.getTitle(), album.getDescription(), album.getArtist(),
				album.getReleaseDate());

	}

}
