package com.benidevo.bookwise.borrower.service;

import com.benidevo.bookwise.borrower.dto.CreateBorrowerDTO;
import com.benidevo.bookwise.borrower.dto.UpdateBorrowerDTO;
import com.benidevo.bookwise.borrower.entity.Borrower;

import java.util.List;

public interface BorrowerService {
    Borrower save(CreateBorrowerDTO createBorrowerDTO);

    Borrower update(UpdateBorrowerDTO updateBorrowerDTO);

    List<Borrower> findAll();

    Borrower findById(Long id) throws RuntimeException;

    void deleteById(Long id);
}
