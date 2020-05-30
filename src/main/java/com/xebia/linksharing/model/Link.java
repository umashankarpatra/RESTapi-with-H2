package com.xebia.linksharing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.xebia.linksharing.model.link.dto.LinkRequest;

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
@Table(name = "LINKS")
public class Link extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "URL")
	private String url;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "FAV_COUNT")
	private Integer favCount;
	
	//@Column(name="TAGS")
	//@Lob
	//private String[] tags;

	@Column(name = "STATUS")
	private Boolean status;

	public static Link of(@Valid @NotEmpty @NotNull LinkRequest linkRequest) {
		// TODO Auto-generated method stub
		Link link = new Link();
		link.setUrl(linkRequest.getUrl());
		link.setTitle(linkRequest.getTitle());
		//link.setTags(linkRequest.getTags());
		link.setStatus(true);
		link.setFavCount(0);
		return link;
	}

	public void update(Integer favCount) {
		// TODO Auto-generated method stub
		this.favCount = favCount;

	}

}
