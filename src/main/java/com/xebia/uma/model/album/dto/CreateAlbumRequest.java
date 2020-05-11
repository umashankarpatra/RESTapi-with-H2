package com.xebia.uma.model.album.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CreateAlbumRequest {

	@NotNull
	private String title;

	@NotNull
	private String description;

	@NotNull
	private String artist;

	@NotNull
	private Date releaseDate;

}
