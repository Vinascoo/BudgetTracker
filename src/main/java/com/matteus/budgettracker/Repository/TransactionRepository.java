package com.matteus.budgettracker.Repository;


import com.matteus.budgettracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
//// This interface provides CRUD operations for the Transaction entity using JPA.
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
