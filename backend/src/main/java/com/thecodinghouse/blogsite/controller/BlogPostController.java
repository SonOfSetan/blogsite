package com.thecodinghouse.blogsite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thecodinghouse.blogsite.model.BlogPost;
import com.thecodinghouse.blogsite.service.BlogPostService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/blogposts")
public class BlogPostController {


    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to the Blog Post API!";
    }

    // Create a new blog post
    @PostMapping("/insertBlogDetails")
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost, @RequestParam Long userId) {
        return blogPostService.createBlogPost(blogPost, userId);  // Pass userId to associate with blog
    }
//    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
//        BlogPost newPost = blogPostService.createBlogPost(blogPost);
//        return ResponseEntity.ok(newPost);
//    }

    // Get all blog posts
    @GetMapping("/getAllBlogs")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return ResponseEntity.ok(blogPosts);
    }

    // Get a blog post by ID
    @GetMapping("/getBlogById")
    public ResponseEntity<BlogPost> getBlogPostById(@RequestParam Long id) {
        Optional<BlogPost> blogPost = blogPostService.getBlogPostById(id);
        return blogPost.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a blog post by ID
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
        Optional<BlogPost> updatedPost = blogPostService.updateBlogPost(id, updatedBlogPost);
        return updatedPost.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a blog post by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }
}
