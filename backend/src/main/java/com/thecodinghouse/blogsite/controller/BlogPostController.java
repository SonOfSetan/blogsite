package com.thecodinghouse.blogsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecodinghouse.blogsite.model.BlogPost;
import com.thecodinghouse.blogsite.service.BlogPostService;

@RestController
@RequestMapping("/api/v1/blogposts")
public class BlogPostController {

	@Autowired
    private BlogPostService blogPostService;

	@GetMapping("/")
    public String home() {
        return "Welcome to the Blog Post API!";
    }
	
    // Create a new blog post
    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost newPost = blogPostService.createBlogPost(blogPost);
        return ResponseEntity.ok(newPost);
    }

    // Get all blog posts
    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return ResponseEntity.ok(blogPosts);
    }

    // Get a blog post by ID
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        return blogPost != null ? ResponseEntity.ok(blogPost) : ResponseEntity.notFound().build();
    }

    // Update a blog post by ID
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
        BlogPost updatedPost = blogPostService.updateBlogPost(id, updatedBlogPost);
        return updatedPost != null ? ResponseEntity.ok(updatedPost) : ResponseEntity.notFound().build();
    }

    // Delete a blog post by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }
}
