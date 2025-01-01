package com.matteus.budgettracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * En entitetsklass som representerar en transaktion i systemet.
 *
 * Används för att mappa transaktionsdata till en databas.
 */
@Entity
public class Transaction {

    @Id // Anger att detta är primärnyckeln för entiteten.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generering av ID med strategin Identity.
    private Long id;

    private String description; // Beskrivning av transaktionen, t.ex. "Köp av mat".
    private double amount; // Beloppet för transaktionen, kan vara positivt eller negativt.

    // Getter och setter för ID.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter och setter för transaktionsbeskrivning.
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter och setter för transaktionsbelopp.
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
