package com.benidevo.bookwise.loan.dto;

import jakarta.validation.constraints.NotNull;

public class CreateLoanDTO {

    @NotNull
    private Long borrowerId;

    @NotNull
    private Long bookId;

    public CreateLoanDTO() {
    }

    public CreateLoanDTO(@NotNull Long borrowerId, @NotNull Long bookId) {
        this.borrowerId = borrowerId;
        this.bookId = bookId;
    }

    public @NotNull Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(@NotNull Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public @NotNull Long getBookId() {
        return bookId;
    }

    public void setBookId(@NotNull Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "CreateLoanDTO{" +
                ", borrowerId=" + borrowerId +
                ", bookId=" + bookId +
                '}';
    }
}
