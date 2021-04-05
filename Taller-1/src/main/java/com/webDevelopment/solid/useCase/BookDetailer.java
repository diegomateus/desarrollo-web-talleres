package com.webDevelopment.solid.useCase;

import com.webDevelopment.solid.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailer {

    private BookService bookService;

    @Autowired
    public BookDetailer(BookService bookService){
        this.bookService = bookService;
    }

    public String execute(long id) throws Exception {
        return this.bookService.getBookDescription(id);
    }
}
