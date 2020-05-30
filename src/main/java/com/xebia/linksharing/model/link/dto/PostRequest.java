package com.xebia.linksharing.model.link.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Getter
public class PostRequest {

	@NotNull
	@Size(max = 100)
	private String title;

	@NotNull
	@Size(max = 250)
	private String description;

	@NotNull
	private String content;

	public static PostRequest of(String title, String description, String content) {
		return new PostRequest(title, description, content);

	}
}
