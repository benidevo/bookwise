package com.benidevo.bookwise.loan.repository;

import com.benidevo.bookwise.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
