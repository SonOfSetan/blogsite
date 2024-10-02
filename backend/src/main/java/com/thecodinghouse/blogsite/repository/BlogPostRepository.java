package com.thecodinghouse.blogsite.repository;
import com.thecodinghouse.blogsite.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
