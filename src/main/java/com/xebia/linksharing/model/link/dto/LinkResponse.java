package com.xebia.linksharing.model.link.dto;

import com.xebia.linksharing.model.Link;

import lombok.Setter;

@Setter
public class LinkResponse {

	private Long id;

	private String url;

	private String title;

	private Integer favCount;

	private Boolean status;

	public static LinkResponse of(final Link link) {

		LinkResponse response = new LinkResponse();

		response.setId(link.getId());
		response.setTitle(link.getTitle());
		response.setFavCount(link.getFavCount());
		response.setUrl(link.getUrl());
		return response;

	}

}
