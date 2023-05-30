package com.benidevo.bookwise.loan.service;

import com.benidevo.bookwise.book.entity.Book;
import com.benidevo.bookwise.book.service.BookService;
import com.benidevo.bookwise.borrower.entity.Borrower;
import com.benidevo.bookwise.borrower.service.BorrowerService;
import com.benidevo.bookwise.common.exception.AppError;
import com.benidevo.bookwise.common.exception.RecordNotFoundException;
import com.benidevo.bookwise.loan.dto.CreateLoanDTO;
import com.benidevo.bookwise.loan.entity.Loan;
import com.benidevo.bookwise.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService{
    private final LoanRepository loanRepository;

    private  final BorrowerService borrowerService;

    private final BookService bookService;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, BorrowerService borrowerService, BookService bookService) {
        this.loanRepository = loanRepository;
        this.borrowerService = borrowerService;
        this.bookService = bookService;
    }

    @Override
    public void save(CreateLoanDTO createLoanDTO) {
        Borrower borrower = this.borrowerService.findById(createLoanDTO.getBorrowerId());
        Book book = this.bookService.findById(createLoanDTO.getBookId());

        Loan newLoan = new Loan();
        newLoan.setBook(book);
        newLoan.setBorrower(borrower);
        newLoan.setLoanDate(new Date());

        this.loanRepository.save(newLoan);

    }

    @Override
    public List<Loan> findAll() {
        return this.loanRepository.findAll();
    }

    @Override
    public Loan findById(Long loanId) {
        Optional<Loan> result =  this.loanRepository.findById(loanId);

        Loan loan = null;
        if (result.isEmpty()) {
            throw new RecordNotFoundException("Loan not found");
        }
        loan = result.get();

        return loan;
    }

    @Override
    public Loan pay(Long loanId) {
        Loan loan = this.findById(loanId);
        if (loan.getReturnedDate() != null) {
            throw new AppError("Loan already repaid");
        }
        loan.setReturnedDate(new Date());
        this.loanRepository.save(loan);

        return loan;
    }
}
