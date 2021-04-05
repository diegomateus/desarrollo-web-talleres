package com.webDevelopment.solid.useCase;

import com.webDevelopment.solid.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorBooksFinder {
    private BookService bookService;

    @Autowired
    public AuthorBooksFinder(BookService bookService){
        this.bookService = bookService;
    }

    public List<String> execute(String authorName) throws Exception {
        return this.bookService.getBooksByAuthor(authorName);
    }
}
