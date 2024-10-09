package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.domain.Book;
import com.mphasis.service.BookService;

@RestController
@RequestMapping("/consumer/book")
public class BookConsumerController {

	@Autowired
	private BookService bookService;

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		
		System.out.println(id+"//////////////");

		Book book = bookService.getBookById(id);  

		return book;

	}

}
