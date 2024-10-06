package com.thecodinghouse.blogsite.repository;

import com.thecodinghouse.blogsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
