package com.benidevo.bookwise.borrower.controller;

import com.benidevo.bookwise.borrower.dto.CreateBorrowerDTO;
import com.benidevo.bookwise.borrower.dto.UpdateBorrowerDTO;
import com.benidevo.bookwise.borrower.entity.Borrower;
import com.benidevo.bookwise.borrower.service.BorrowerService;
import com.benidevo.bookwise.common.annotation.HandleValidationErrors;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/borrowers")
public class BorrowerController {
    private final BorrowerService borrowerService;

    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping
    public List<Borrower> getBorrowers() {
        return this.borrowerService.findAll();
    }

    @PostMapping
    @HandleValidationErrors
    public Borrower createBorrower(@Valid @RequestBody CreateBorrowerDTO borrower, BindingResult result) {
        return this.borrowerService.save(borrower);
    }

    @GetMapping("/{borrowerId}")
    public Borrower getBorrower(@PathVariable Long borrowerId) {
        return this.borrowerService.findById(borrowerId);
    }

    @PutMapping("/{borrowerId}")
    @HandleValidationErrors
    public Borrower updateBorrow(
            @Valid @RequestBody UpdateBorrowerDTO payload,
            BindingResult bindingResult,
            @PathVariable Long borrowerId) {
        payload.setId(borrowerId);
        return this.borrowerService.update(payload);
    }

    @DeleteMapping("/{borrowerId}")
    public void deleteBorrower(@PathVariable Long borrowerId) {
        this.borrowerService.deleteById(borrowerId);
    }
}
