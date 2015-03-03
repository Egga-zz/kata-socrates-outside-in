package de.egga.mockist;


import de.egga.mockist.transactions.Transaction;

import java.util.List;

/**
 * @author egga
 */
public class Account {

    private final TransactionRepository repository;
    private final DateProvider dateProvider;
    private final StatementPrinter statementPrinter;


    public Account(TransactionRepository repository, DateProvider dateProvider, StatementPrinter statementPrinter) {
        this.repository = repository;
        this.dateProvider = dateProvider;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        repository.persist(amount, dateProvider.getDate());
    }

    public void withdraw(int amount) {
        repository.persist(-amount, dateProvider.getDate());
    }

    public void printStatement() {
        List<Transaction> transactions = repository.getTransactions();
        statementPrinter.print(transactions);
    }
}
