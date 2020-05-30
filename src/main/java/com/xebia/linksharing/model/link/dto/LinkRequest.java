package com.xebia.linksharing.model.link.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Setter
@Getter
public class LinkRequest {
	
	private String url;
	
	private String title;
	
	private String[] tags;
		
}
