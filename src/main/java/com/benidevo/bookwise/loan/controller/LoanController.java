package com.benidevo.bookwise.loan.controller;

import com.benidevo.bookwise.common.annotation.HandleValidationErrors;
import com.benidevo.bookwise.common.exception.AppError;
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
    public Loan createLoan(@Valid @RequestBody CreateLoanDTO createLoanDTO, BindingResult result) {
        return this.loanService.save(createLoanDTO);
    }

    @GetMapping
    public List<Loan> getLoans(@RequestParam(required = false) Long bookId,
                               @RequestParam(required = false) Long borrowerId) {
        if (bookId != null && borrowerId != null) {
            throw new AppError("Both borrowerId and bookId cannot be provided at the same time.");
        }
        return this.loanService.findAll(bookId, borrowerId);
    }

    @GetMapping("/open")
    public List<Loan> getOpenLoans(){
        return this.loanService.findOpen();
    }

    @GetMapping("/closed")
    public List<Loan> getClosedLoans() {
        return this.loanService.findClosed();
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
