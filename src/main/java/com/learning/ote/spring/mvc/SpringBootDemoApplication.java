package com.learning.ote.spring.mvc;

import com.learning.ote.spring.mvc.domain.Author;
import com.learning.ote.spring.mvc.service.AuthorService;
import com.learning.ote.spring.mvc.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class SpringBootDemoApplication {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
