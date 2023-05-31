package com.benidevo.bookwise.book.service;

import com.benidevo.bookwise.book.dto.CreateBookDTO;
import com.benidevo.bookwise.book.dto.UpdateBookDTO;
import com.benidevo.bookwise.book.entity.Book;
import com.benidevo.bookwise.book.repository.BookRepository;
import com.benidevo.bookwise.common.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(CreateBookDTO bookDTO) {
        Book book = new Book(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getISBN(),
                                 bookDTO.getPublicationYear(), bookDTO.getQuantity());
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> findAll(String title) {
        if (title != null && !title.isEmpty()) {
            return this.bookRepository.findByTitleContainingIgnoreCase(title);
        }
        return this.bookRepository.findAll();
    }


    @Override
    public Book findById(Long bookId) {
        Optional<Book> result = this.bookRepository.findById(bookId);
        Book book = null;

        if (result.isEmpty()) {
            throw new RecordNotFoundException("Book not found");
        } else {
            book = result.get();
        }

        return book;
    }

    @Override
    public Book update(Long bookId, UpdateBookDTO updateBookDTO) {
        Book book = this.findById(bookId);
        updateBookDTO.setId(bookId);
        updateBookDTO.updateFields(book);

        return this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }
}
