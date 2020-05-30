package com.xebia.linksharing.model.link.dto;

import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Getter
public class CommentRequest {

	@NotNull
	private String text;

	public static CommentRequest of(String text) {
		return new CommentRequest(text);

	}

}
