package com.webDevelopment.solid.models;

import java.util.Calendar;

public class Book {

    private Long id;
    private String title;
    private String author;
    private Integer publishedYear;
    private Double price;
    private Integer pagesNumber;
    private String description;

    public Book(Long id, String title, String author, Integer publishedYear, Double price, Integer pagesNumber, String description) throws Exception {
        this.id = id;
        this.title = title;
        this.author = author;
        this.validatePublishedYear(publishedYear);
        this.publishedYear = publishedYear;
        this.validatePrice(price);
        this.price = price;
        this.pagesNumber = pagesNumber;
        this.validateDescription(description);
        this.description = description;
    }

    public String createBookDetail(){
        return "title: " + this.title + ", author: " + this.author + ", published year: " + this.publishedYear + ", price: " + this.price + ", pages: " + this.pagesNumber + ", description: " + this.description +".";
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPagesNumber() {
        return pagesNumber;
    }

    public String getDescription() {
        return description;
    }
    
    private void validateDescription(String description) throws Exception {
        if(description.length() > 200)
            throw new Exception("Tamñano de la descripcion de mas de 200 caracteres");
    }

    private void validatePrice(Double price) throws Exception {
        if(price < 10000 || price % 1 != 0)
            throw new Exception("El precio es menor a 10.000 o tiene decimales");
    }

    private void validatePublishedYear(Integer publishedYear) throws Exception {
        if(publishedYear < 1000 || publishedYear > Calendar.getInstance().get(Calendar.YEAR))
            throw new Exception("Año de publicación invalido");
    }
    
}
