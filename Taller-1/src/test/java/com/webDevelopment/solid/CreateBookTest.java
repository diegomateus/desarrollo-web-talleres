package com.webDevelopment.solid;

import com.webDevelopment.solid.useCase.BookCreator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CreateBookTest {
    private BookCreator BookCreator;

    @Test
    public void createBookTest(){

        //assertEquals(expected, newBookCreator.execute());
    }
}
