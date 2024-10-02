package com.thecodinghouse.blogsite.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
}
