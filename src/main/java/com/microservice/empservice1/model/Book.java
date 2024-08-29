package com.microservice.empservice1.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Book {
    @Id
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private double bookPrice;

    @Column(name = "book_author")
    private String bookAuthor;

    public Book() {
    }

    public Book(int bookId, String bookName, double bookPrice, String bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (Double.compare(book.bookPrice, bookPrice) != 0) return false;
        if (!Objects.equals(bookName, book.bookName)) return false;
        return Objects.equals(bookAuthor, book.bookAuthor);
    }

    @Override
    public int hashCode() {
        int result;
        result = bookId;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + Double.hashCode(bookPrice);
        result = 31 * result + (bookAuthor != null ? bookAuthor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }


}
