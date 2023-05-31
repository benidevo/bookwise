package com.benidevo.bookwise.book.service;

import com.benidevo.bookwise.book.dto.CreateBookDTO;
import com.benidevo.bookwise.book.dto.UpdateBookDTO;
import com.benidevo.bookwise.book.entity.Book;

import java.util.List;

public interface BookService {
    Book save(CreateBookDTO bookDTO);

    List<Book> findAll(String title);

    Book findById(Long bookId);

    Book update(Long bookId, UpdateBookDTO updateBookDTO);

    void deleteById(Long bookId);
}
