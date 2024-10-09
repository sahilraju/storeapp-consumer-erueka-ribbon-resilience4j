package com.mphasis.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mphasis.domain.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class BookService {
	
	@Autowired
	private RestTemplate restTemplate;
    @Retry(name = "book-service") 
	@CircuitBreaker(name = "book-service", fallbackMethod = "fallbackGetBookById") 
	public Book getBookById(Long id) { 
		
		System.out.println(id+"//////////////");

		Book book = restTemplate.getForObject("http://book-service/book/" + id, Book.class);

		return book;

	}
	
	public Book fallbackGetBookById(Long id, Throwable cause) {
		
		System.out.println("Some error caused: "+cause);
		return new Book(id, "title", "author", "isbn", 100, 2100, "publisher"); 
		
	}

}
