package com.benidevo.bookwise.book.repository;

import com.benidevo.bookwise.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
