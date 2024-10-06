package com.thecodinghouse.blogsite.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.thecodinghouse.blogsite.model.User;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;

	@Column(length = 5000)
	private String content;

	private String imageUrl;

	private String videoUrl;

	private String embeddedLink;

	private LocalDateTime createdAt;

	@ElementCollection
	private List<String> tag_list;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") // Foreign key
	private User user;

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now(); // Automatically set the createdAt field
	}
}
