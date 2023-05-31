package com.benidevo.bookwise.loan.repository;

import com.benidevo.bookwise.book.entity.Book;
import com.benidevo.bookwise.borrower.entity.Borrower;
import com.benidevo.bookwise.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByReturnedDateNotNull();

    List<Loan> findByReturnedDateIsNull();

    List<Loan> findByBorrower(Borrower borrower);

    List<Loan> findByBook(Book book);
}
