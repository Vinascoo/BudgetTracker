package com.matteus.budgettracker.repository;

import com.matteus.budgettracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ett repository-gränssnitt som hanterar CRUD-operationer (Create, Read, Update, Delete)
 * för Transaction-entiteten med hjälp av Spring Data JPA.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Alla standardmetoder för databasinteraktion tillhandahålls automatiskt av JpaRepository.
}
