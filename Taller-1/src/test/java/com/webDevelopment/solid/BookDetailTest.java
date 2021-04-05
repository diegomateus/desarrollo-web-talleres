package com.webDevelopment.solid;

import com.webDevelopment.solid.services.BookServiceLocal;
import com.webDevelopment.solid.useCase.BookDetailer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookDetailTest {
    private BookDetailer bookDetailer;

    @Test
    public void createBookTest() throws Exception {

        this.bookDetailer = new BookDetailer(new BookServiceLocal());
        String expected = "title: " + "1984" + ", author: " + "Gorge Orwell" + ", published year: " + "1949" + ", price: " + "19000" + ", pages: " + "326" + ", description: " + "Es la distopia de la epoca" +".";
        assertEquals(expected, bookDetailer.execute(1));

    }
}
