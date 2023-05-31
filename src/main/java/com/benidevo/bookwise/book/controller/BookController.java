package com.benidevo.bookwise.book.controller;

import com.benidevo.bookwise.book.dto.CreateBookDTO;
import com.benidevo.bookwise.book.dto.UpdateBookDTO;
import com.benidevo.bookwise.book.entity.Book;
import com.benidevo.bookwise.book.service.BookService;
import com.benidevo.bookwise.common.annotation.HandleValidationErrors;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @HandleValidationErrors
    public Book createBook(@Valid @RequestBody CreateBookDTO createBookDTO, BindingResult result) {
        return this.bookService.save(createBookDTO);
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String title) {
        return this.bookService.findAll(title);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return this.bookService.findById(bookId);
    }

    @PutMapping("/{bookId}")
    @HandleValidationErrors
    public Book updateBook(@Valid @RequestBody UpdateBookDTO updateBookDTO,
                           BindingResult bindingResult, @PathVariable Long bookId) {
        return this.bookService.update(bookId, updateBookDTO);
    }


    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        this.bookService.deleteById(bookId);
    }
}
