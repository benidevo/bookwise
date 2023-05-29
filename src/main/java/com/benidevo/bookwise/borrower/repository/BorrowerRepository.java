package com.benidevo.bookwise.borrower.repository;

import com.benidevo.bookwise.borrower.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
