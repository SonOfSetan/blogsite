package com.thecodinghouse.blogsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thecodinghouse.blogsite.model.BlogPost;
import com.thecodinghouse.blogsite.repository.BlogPostRepository;

@Service
public class BlogPostService {

	@Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost createBlogPost(BlogPost blogPost) {
        blogPost.setCreatedAt(java.time.LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost) {
        BlogPost existingBlogPost = blogPostRepository.findById(id).orElse(null);
        if (existingBlogPost != null) {
            existingBlogPost.setTitle(updatedBlogPost.getTitle());
            existingBlogPost.setContent(updatedBlogPost.getContent());
            existingBlogPost.setImageUrl(updatedBlogPost.getImageUrl());
            existingBlogPost.setVideoUrl(updatedBlogPost.getVideoUrl());
            existingBlogPost.setEmbeddedLink(updatedBlogPost.getEmbeddedLink());
            return blogPostRepository.save(existingBlogPost);
        }
        return null;
    }

    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }
}
