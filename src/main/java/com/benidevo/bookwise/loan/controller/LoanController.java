package com.benidevo.bookwise.loan.controller;

import com.benidevo.bookwise.common.annotation.HandleValidationErrors;
import com.benidevo.bookwise.loan.dto.CreateLoanDTO;
import com.benidevo.bookwise.loan.entity.Loan;
import com.benidevo.bookwise.loan.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/loans")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @HandleValidationErrors
    public void createLoan(@Valid @RequestBody CreateLoanDTO createLoanDTO, BindingResult result) {
        this.loanService.save(createLoanDTO);
    }

    @GetMapping
    public List<Loan> getLoans() {
        return this.loanService.findAll();
    }

    @GetMapping("/{loanId}")
    public Loan getLoan(@PathVariable Long loanId) {
        return this.loanService.findById(loanId);
    }

    @PatchMapping("/{loanId}/pay")
    public Loan payLoan(@PathVariable Long loanId) {
        return this.loanService.pay(loanId);
    }
}
