package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCase.BookCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.webDevelopment.solid.SolidApplication.LOGGER;

@RestController
@RequestMapping(value = "/create")
public class CreateNewBookController {

    private BookCreator bookCreator;

    @Autowired
    public CreateNewBookController (BookCreator bookCreator){
        this.bookCreator = bookCreator;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createBook(@RequestBody Book book){
        long bookId = 0l;
        HttpStatus code = HttpStatus.FORBIDDEN;

        try {
            bookId = this.bookCreator.execute(book);
            code = HttpStatus.OK;
        }
        catch (Exception e){
            LOGGER.error("CreateNewBookController.createBook Cause: " + e.getMessage());
        }
        return ResponseEntity.status(code).body(bookId);
    }


}
