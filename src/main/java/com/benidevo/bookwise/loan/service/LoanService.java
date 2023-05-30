package com.benidevo.bookwise.loan.service;

import com.benidevo.bookwise.loan.dto.CreateLoanDTO;
import com.benidevo.bookwise.loan.entity.Loan;

import java.util.List;

public interface LoanService {
    void save(CreateLoanDTO createLoanDTO);

    List<Loan> findAll();

    Loan findById(Long loanId);

    Loan pay(Long loanId);
}
