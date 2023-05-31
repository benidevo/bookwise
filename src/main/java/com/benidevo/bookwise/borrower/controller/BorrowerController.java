package com.benidevo.bookwise.borrower.controller;

import com.benidevo.bookwise.borrower.dto.CreateBorrowerDTO;
import com.benidevo.bookwise.borrower.dto.UpdateBorrowerDTO;
import com.benidevo.bookwise.borrower.entity.Borrower;
import com.benidevo.bookwise.borrower.service.BorrowerService;
import com.benidevo.bookwise.common.annotation.HandleValidationErrors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Borrowers", description = "Manage Borrowers")
@RestController
@RequestMapping("api/borrowers")
public class BorrowerController {
    private final BorrowerService borrowerService;

    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @Operation(description = "List all borrowers")
    @GetMapping
    public List<Borrower> getBorrowers() {
        return this.borrowerService.findAll();
    }

    @Operation(description = "Create a Borrower")
    @ApiResponse(responseCode = "201")
    @PostMapping
    @HandleValidationErrors
    public Borrower createBorrower(@Valid @RequestBody CreateBorrowerDTO borrower, BindingResult result) {
        return this.borrowerService.save(borrower);
    }

    @Operation(description = "Get a Borrower by ID")
    @GetMapping("/{borrowerId}")
    public Borrower getBorrower(@PathVariable Long borrowerId) {
        return this.borrowerService.findById(borrowerId);
    }

    @Operation(description = "Update a Borrower")
    @PutMapping("/{borrowerId}")
    @HandleValidationErrors
    public Borrower updateBorrow(
            @Valid @RequestBody UpdateBorrowerDTO payload,
            BindingResult bindingResult,
            @PathVariable Long borrowerId) {
        payload.setId(borrowerId);
        return this.borrowerService.update(payload);
    }

    @Operation(description = "Delete a Borrower")
    @DeleteMapping("/{borrowerId}")
    public void deleteBorrower(@PathVariable Long borrowerId) {
        this.borrowerService.deleteById(borrowerId);
    }
}
