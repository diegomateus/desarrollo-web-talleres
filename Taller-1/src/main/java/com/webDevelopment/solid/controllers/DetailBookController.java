package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.useCase.BookDetailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@RestController
@RequestMapping(value = "/book")
public class DetailBookController {

    private BookDetailer bookDetailer;

    @Autowired
    public DetailBookController (BookDetailer bookDetailer){
        this.bookDetailer = bookDetailer;
    }

    @GetMapping(value = "/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBookDetail(@PathVariable(value = "bookId")String id){
        String bookDetail = null;
        HttpStatus code = HttpStatus.FORBIDDEN;

        try {
            bookDetail = this.bookDetailer.execute(Long.parseLong(id));
            code = HttpStatus.OK;
        }
        catch (Exception e){
            LOGGER.error("DetailBookController.getBookDetail Cause: " + e.getMessage());
        }
        return ResponseEntity.status(code).body(bookDetail);
    }
}
