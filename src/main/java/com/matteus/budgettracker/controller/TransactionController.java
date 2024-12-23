package com.matteus.budgettracker.controller;


import com.matteus.budgettracker.model.Transaction;
import com.matteus.budgettracker.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// This class defines the REST API endpoints for managing transactions.
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionRepository repository;
    // Constructor injection to provide the repository dependency
    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }
    // GET endpoint to retrieve all transactions from the database.
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }
    // POST endpoint to create a new transaction in the database.
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }
    // DELETE endpoint to remove a transaction
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

