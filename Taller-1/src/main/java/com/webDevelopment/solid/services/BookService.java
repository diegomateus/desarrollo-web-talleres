package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public List<String> getBooksByAuthor(String authorName) throws Exception;
    public Long addBook (Book book) throws Exception;
    public String getBookDescription (long id) throws Exception;
}
