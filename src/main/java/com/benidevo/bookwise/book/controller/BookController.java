package com.benidevo.bookwise.book.controller;

import com.benidevo.bookwise.book.dto.CreateBookDTO;
import com.benidevo.bookwise.book.dto.UpdateBookDTO;
import com.benidevo.bookwise.book.entity.Book;
import com.benidevo.bookwise.book.service.BookService;
import com.benidevo.bookwise.common.annotation.HandleValidationErrors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Books", description = "Manage Books")
@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(description = "Create a Book")
    @ApiResponse(responseCode = "201")
    @PostMapping
    @HandleValidationErrors
    public Book createBook(@Valid @RequestBody CreateBookDTO createBookDTO, BindingResult result) {
        return this.bookService.save(createBookDTO);
    }

    @Operation(description = "Get all Books")
    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String title) {
        return this.bookService.findAll(title);
    }

    @Operation(description = "Get Book by ID")
    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return this.bookService.findById(bookId);
    }

    @Operation(description = "Update a Book")
    @PutMapping("/{bookId}")
    @HandleValidationErrors
    public Book updateBook(@Valid @RequestBody UpdateBookDTO updateBookDTO,
                           BindingResult bindingResult, @PathVariable Long bookId) {
        return this.bookService.update(bookId, updateBookDTO);
    }

    @Operation(description = "Delete a Book")
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        this.bookService.deleteById(bookId);
    }
}
