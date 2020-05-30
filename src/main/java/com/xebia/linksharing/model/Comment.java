package com.xebia.linksharing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.xebia.linksharing.model.link.dto.CommentRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comments")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Comment extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String text;

	@ManyToOne()
	@JoinColumn(name = "post_id", nullable = false)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnore
	private Post post;

	public static Comment of(CommentRequest request) {
		Comment comment = new Comment();
		comment.setText(request.getText());
		return comment;
	}

	// Getters and Setters (Omitted for brevity)
}