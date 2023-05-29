package com.benidevo.bookwise.borrower.service;

import com.benidevo.bookwise.borrower.entity.Borrower;

import java.util.List;

public interface BorrowerService {
    Borrower save(Borrower borrower);

    List<Borrower> findAll();

    Borrower findById(Long id) throws RuntimeException;

    void deleteById(Long id);
}
