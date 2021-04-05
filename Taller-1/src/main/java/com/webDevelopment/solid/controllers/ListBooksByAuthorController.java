package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.useCase.AuthorBooksFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@RestController
@RequestMapping(value = "/books")
public class ListBooksByAuthorController {
    private AuthorBooksFinder authorBooksFinder;

    @Autowired
    public ListBooksByAuthorController (AuthorBooksFinder authorBooksFinder){
        this.authorBooksFinder = authorBooksFinder;
    }

    @GetMapping(value = "/{authorName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getBooksByAuthor(@PathVariable(value = "authorName") String AuthorName){
        List<String> booksNames = null;
        HttpStatus code = HttpStatus.FORBIDDEN;

        try {
            booksNames = this.authorBooksFinder.execute(AuthorName);
            code = HttpStatus.OK;
        }
        catch (Exception e){
            LOGGER.error("ListBooksByAuthorController.getBooksByAuthor Cause: " + e.getMessage());
        }
        return ResponseEntity.status(code).body(booksNames);
    }

}
