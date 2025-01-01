package com.matteus.budgettracker.controller;

import com.matteus.budgettracker.model.Transaction;
import com.matteus.budgettracker.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Denna klass definierar REST API-endpoints för att hantera transaktioner.
 */
@RestController
@RequestMapping("/api/transactions") // Bas-URL för alla transaktionsrelaterade endpoints.
public class TransactionController {

    private final TransactionRepository repository;

    /**
     * Konstruktor för att injicera repository-beroendet.
     *
     * @param repository Transaktionsrepository som hanterar databasoperationer.
     */
    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    /**
     * GET-endpoint för att hämta alla transaktioner från databasen.
     *
     * @return En lista med alla transaktioner.
     */
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    /**
     * POST-endpoint för att skapa en ny transaktion i databasen.
     *
     * @param transaction Transaktionen som ska sparas.
     * @return Den sparade transaktionen.
     */
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    /**
     * DELETE-endpoint för att ta bort en transaktion från databasen.
     *
     * @param id ID för den transaktion som ska raderas.
     */
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
