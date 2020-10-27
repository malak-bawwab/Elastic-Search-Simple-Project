package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookServiceImpl;
import com.google.common.collect.Iterables;

@RestController

public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookServiceImpl bookService;

	@RequestMapping(value = "/All")

	public String getAllBooks() {

		return "Total :" + Iterables.size(bookService.findAll());
	}

	@RequestMapping(value = "/book/add")

	public String addBook() {
		Book b = new Book();
		b.setTitle("Test");
		bookService.save(b);
		logger.info("size is " + Iterables.size(bookService.findAll()));
		return "new book is added succesfully";
	}
}
