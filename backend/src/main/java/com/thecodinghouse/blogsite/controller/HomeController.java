package com.thecodinghouse.blogsite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
    public String index() {
        // If you have an index.html, it will serve that
        return "index";
    }
}
