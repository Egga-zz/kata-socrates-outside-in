package de.egga.classicist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author egga
 */
public class Account {

    public static final String HEADER = "DATE | AMOUNT | BALANCE";
    public static final String SEPARATOR = " | ";

    private ConsoleOutput console;
    private DateProvider clock;

    private List<Transaction> deposited = new ArrayList<>();

    public Account(ConsoleOutput console, DateProvider clock) {
        this.console = console;
        this.clock = clock;
    }

    public void deposit(int i) {
        deposited.add(new Transaction(i, clock.getDate()));
    }

    public void withdraw(int i) {

    }

    public void printStatement() {
        console.printLine(HEADER);
        int balance = 0;
        for (Transaction transaction : deposited) {
            balance += transaction.getAmount();
            console.printLine(transaction.getDate() + SEPARATOR + transaction.getAmount() + SEPARATOR + balance);
        }
    }
}
