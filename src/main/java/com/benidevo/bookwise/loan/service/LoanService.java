package com.benidevo.bookwise.loan.service;

import com.benidevo.bookwise.loan.dto.CreateLoanDTO;
import com.benidevo.bookwise.loan.entity.Loan;

import java.util.List;

public interface LoanService {
    Loan save(CreateLoanDTO createLoanDTO);

    List<Loan> findAll(Long bookId, Long borrowerId);

    Loan findById(Long loanId);

    Loan pay(Long loanId);

    List<Loan> findOpen();

    List<Loan> findClosed();
}
