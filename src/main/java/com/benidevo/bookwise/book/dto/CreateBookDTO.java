package com.benidevo.bookwise.book.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateBookDTO {
    @NotNull
    @Size(min = 3, max = 100)
    private String author;

    @NotNull
    @Size(min = 3, max = 100)
    private String title;

    private String ISBN;


    private Integer publicationYear;

    @NotNull
    private Integer quantity;

    public CreateBookDTO() {
    }

    public CreateBookDTO(@NotNull String author, @NotNull String title, String ISBN, Integer publicationYear, @NotNull Integer quantity) {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
    }

    public @NotNull String getAuthor() {
        return author;
    }

    public void setAuthor(@NotNull String author) {
        this.author = author;
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public @NotNull Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "CreateBookDTO{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publicationYear=" + publicationYear + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
