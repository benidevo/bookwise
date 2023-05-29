package com.benidevo.bookwise.borrower.service;

import com.benidevo.bookwise.borrower.entity.Borrower;
import com.benidevo.bookwise.borrower.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerServiceImpl implements BorrowerService{
    private final BorrowerRepository borrowerRepository;

    @Autowired
    public BorrowerServiceImpl(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public Borrower save(Borrower borrower) {
        return this.borrowerRepository.save(borrower);
    }

    @Override
    public List<Borrower> findAll() {
        return this.borrowerRepository.findAll();
    }

    @Override
    public Borrower findById(Long id) throws RuntimeException {
        Optional<Borrower> result  = this.borrowerRepository.findById(id);

        Borrower borrower = null;

        if (result.isPresent()) {
            borrower = result.get();
        } else {
            throw new RuntimeException("Borrower not found");
        }

        return borrower;
    }

    @Override
    public void deleteById(Long id) {
        this.borrowerRepository.deleteById(id);
    }
}
