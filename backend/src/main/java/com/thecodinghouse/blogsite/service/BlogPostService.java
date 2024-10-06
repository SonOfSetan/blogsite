package com.thecodinghouse.blogsite.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.thecodinghouse.blogsite.model.User;
import com.thecodinghouse.blogsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thecodinghouse.blogsite.model.BlogPost;
import com.thecodinghouse.blogsite.repository.BlogPostRepository;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private UserRepository userRepository;

    public BlogPost createBlogPost(BlogPost blogPost, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        blogPost.setUser(user);  // Associate blog post with the user
        blogPost.setCreatedAt(LocalDateTime.now());  // Set created date
        return blogPostRepository.save(blogPost);  // Save blog post
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    public Optional<BlogPost> updateBlogPost(Long id, BlogPost updatedBlogPost) {
        return blogPostRepository.findById(id).map(existingBlogPost -> {
            if (updatedBlogPost.getTitle() != null) {
                existingBlogPost.setTitle(updatedBlogPost.getTitle());
            }
            if (updatedBlogPost.getContent() != null) {
                existingBlogPost.setContent(updatedBlogPost.getContent());
            }
            if (updatedBlogPost.getImageUrl() != null) {
                existingBlogPost.setImageUrl(updatedBlogPost.getImageUrl());
            }
            if (updatedBlogPost.getVideoUrl() != null) {
                existingBlogPost.setVideoUrl(updatedBlogPost.getVideoUrl());
            }
            if (updatedBlogPost.getEmbeddedLink() != null) {
                existingBlogPost.setEmbeddedLink(updatedBlogPost.getEmbeddedLink());
            }
            if (updatedBlogPost.getTag_list() != null) {
                existingBlogPost.setTag_list(updatedBlogPost.getTag_list());
            }
            return blogPostRepository.save(existingBlogPost);
        });
    }

    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }
}
