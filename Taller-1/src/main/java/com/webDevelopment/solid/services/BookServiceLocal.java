package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceLocal implements BookService{

    private List<Book> books;

    public BookServiceLocal() throws Exception {
        this.books = new ArrayList<Book>();
        books.add(new Book(1L,"1984", "Gorge Orwell", 1949, 19000d ,326,"Es la distopia de la epoca"));
        books.add(new Book(2L,"Rebelión en la granja", "Gorge Orwell", 1945, 20000d ,126, "Satira a los gobernantes"));
        books.add(new Book(3L,"Subir a por aire", "Gorge Orwell", 1939, 30000d ,235, "No lo he leido"));
        books.add(new Book(4L,"Satanás", "Mario Mendoza", 2002, 45000d ,128, "Como se vive en Bogota"));
        books.add(new Book(5L,"Scoprio City", "Mario Mendoza", 1998, 45000d ,152, "Detective privado"));
    }

    @Override
    public List<String> getBooksByAuthor(String authorName) throws Exception {
        List<String> booksNames = new ArrayList<>();

        for (Book book : this.books) {
            if (authorName.equals(book.getAuthor())) {
                booksNames.add(book.getTitle());
            }
        }

        if(booksNames.size() > 0){
            return booksNames;
        }
        else{
            throw new Exception("BookServiceLocal.getBooksByAuthor Causa: No hay libros de este autor");
        }

    }

    @Override
    public Long addBook(Book book) throws Exception {
        if(this.validateId(book)){
            this.books.add(book);
        }
        else{
            throw new Exception("BookServiceLocal.addBook Causa: ID ya existe");
        }
        return book.getId();
    }

    @Override
    public String getBookDescription(long id) throws Exception {

        String message = "null";
        for (Book book : books) {
            if (book.getId() == id) {
                message = book.createBookDetail();
            }
        }

        if(!message.equals("null")){
            return message;
        }
        else{
            throw new Exception("BookServiceLocal.getBookDescription Causa: No existe el libro");
        }

    }

    private boolean validateId(Book book){
        boolean exist = false;
        for(int i = 0; i < books.size(); i ++){
            if(this.books.get(i).getId().equals(book.getId())){
                exist = true;
                i = this.books.size();
            }
        }
        return exist;
    }
}
