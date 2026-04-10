package com.re.org.model;

public class Book {
    private int id;
    private String nameBook;
    private String author;
    private double price;

    public Book() {
    }

    public Book(int id, String nameBook, String author, double price) {
        this.id = id;
        this.nameBook = nameBook;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
