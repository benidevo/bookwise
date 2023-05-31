package com.benidevo.bookwise.loan.controller;

import com.benidevo.bookwise.common.annotation.HandleValidationErrors;
import com.benidevo.bookwise.common.exception.AppError;
import com.benidevo.bookwise.loan.dto.CreateLoanDTO;
import com.benidevo.bookwise.loan.entity.Loan;
import com.benidevo.bookwise.loan.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Loans", description = "Manage Loans")
@RestController
@RequestMapping("api/loans")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @Operation(description = "Create loan by associating a Borrower and a Book")
    @ApiResponse(responseCode = "201")
    @PostMapping
    @HandleValidationErrors
    public Loan createLoan(@Valid @RequestBody CreateLoanDTO createLoanDTO, BindingResult result) {
        return this.loanService.save(createLoanDTO);
    }

    @Operation(description = "Get all loans. You can also filter by Borrower or by Book")
    @GetMapping
    public List<Loan> getLoans(@RequestParam(required = false) Long bookId,
                               @RequestParam(required = false) Long borrowerId) {
        if (bookId != null && borrowerId != null) {
            throw new AppError("Both borrowerId and bookId cannot be provided at the same time.");
        }
        return this.loanService.findAll(bookId, borrowerId);
    }

    @Operation(description = "Get a list of loans that are still open. " +
            "A loan is open when the borrower has not returned the book")
    @GetMapping("/open")
    public List<Loan> getOpenLoans(){
        return this.loanService.findOpen();
    }

    @Operation(description = "Get a list of loans that have been closed. " +
            "A loan is closed when the borrower returns the book")
    @GetMapping("/closed")
    public List<Loan> getClosedLoans() {
        return this.loanService.findClosed();
    }

    @Operation(description = "Retrieve a Loan by its ID")
    @GetMapping("/{loanId}")
    public Loan getLoan(@PathVariable Long loanId) {
        return this.loanService.findById(loanId);
    }


    @Operation(description = "Close a loan that. A loan is closed when the borrower returns the book")
    @PatchMapping("/{loanId}/close")
    public Loan closeLoan(@PathVariable Long loanId) {
        return this.loanService.pay(loanId);
    }
}
