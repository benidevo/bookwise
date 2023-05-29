package com.benidevo.bookwise.borrower.controller;

import com.benidevo.bookwise.borrower.entity.Borrower;
import com.benidevo.bookwise.borrower.service.BorrowerService;
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
    public Borrower createBorrower(@RequestBody Borrower borrower) {
        return this.borrowerService.save(borrower);
    }

    @GetMapping("/{borrowerId}")
    public Borrower getBorrower(@PathVariable Long borrowerId) {
        return this.borrowerService.findById(borrowerId);
    }

    @PutMapping("/{borrowerId}")
    public Borrower updateBorrow(@RequestBody Borrower borrower, @PathVariable Long borrowerId) {
        borrower.setId(borrowerId);
        return this.borrowerService.save(borrower);
    }

    @DeleteMapping("/{borrowerId}")
    public void deleteBorrower(@PathVariable Long borrowerId) {
        this.borrowerService.deleteById(borrowerId);
    }
}
