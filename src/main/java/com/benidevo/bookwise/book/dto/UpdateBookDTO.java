package com.benidevo.bookwise.book.dto;

import com.benidevo.bookwise.book.entity.Book;
import jakarta.validation.constraints.Size;


public class UpdateBookDTO {

    private Long id;
    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 3, max = 100)
    private String author;

    @Size(min = 3, max = 100)
    private String ISBN;

    private Integer publishedYear;

    private Integer quantity;

    public UpdateBookDTO() {
    }

    public UpdateBookDTO(String title, String author, String ISBN, Integer publishedYear, Integer quantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publishedYear = publishedYear;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void updateFields(Book book) {
        if (this.author != null) {
            book.setAuthor(this.author);
        }
        if (this.title != null) {
            book.setTitle(this.title);
        }
        if (this.ISBN != null) {
            book.setISBN(this.ISBN);
        }
        if (this.quantity != null) {
            book.setQuantity(this.quantity);
        }
        if (this.publishedYear != null) {
            book.setPublicationYear(this.publishedYear);
        }
    }

    @Override
    public String toString() {
        return "UpdateBookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publishedYear=" + publishedYear +
                ", quantity=" + quantity +
                '}';
    }
}
