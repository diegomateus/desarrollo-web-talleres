package com.webDevelopment.solid.useCase;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCreator {
    private BookService bookService;

    @Autowired
    public BookCreator(BookService bookService){
        this.bookService = bookService;
    }

    public Long execute(Book book) throws Exception {
        this.bookService.addBook(book);
        return book.getId();
    }
}
