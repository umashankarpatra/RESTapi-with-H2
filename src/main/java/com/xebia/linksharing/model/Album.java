package com.xebia.linksharing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xebia.linksharing.model.link.dto.CreateAlbumRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "ALBUMS")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ARTIST")
	private String artist;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIME")
	private Date releaseDate;

	public boolean updateDescription(final String description) {
		this.description = description;

		return true;
	}

	public static Album of(CreateAlbumRequest createAlbum) {

		Album album = new Album();
		album.setArtist(createAlbum.getArtist());
		album.setDescription(createAlbum.getDescription());
		album.setTitle(createAlbum.getTitle());
		album.setReleaseDate(new Date());
		return album;

	}
}
