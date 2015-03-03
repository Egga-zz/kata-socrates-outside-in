package de.egga.mockist;

import de.egga.mockist.transactions.AccountStatement;
import de.egga.mockist.transactions.Transaction;

import java.util.List;

import static java.util.Collections.reverse;

/**
 * @author egga
 */
public class StatementPrinter {

    public static final String TITLE_DATE = "DATE";
    public static final String TITLE_AMOUNT = "AMOUNT";
    public static final String TITLE_BALANCE = "BALANCE";

    private ConsolePrinter console;
    private BalanceCalculator balanceCalculator;

    public StatementPrinter(ConsolePrinter console, BalanceCalculator balanceCalculator) {
        this.console = console;
        this.balanceCalculator = balanceCalculator;
    }

    public void print(List<Transaction> transactions) {
        printHeadLine();
        printTransactions(transactions);
    }

    private void printHeadLine() {
        AccountStatement statement = new AccountStatement(TITLE_DATE, TITLE_AMOUNT, TITLE_BALANCE);
        console.printLine(statement.toString());
    }

    private void printTransactions(List<Transaction> transactions) {
        List<AccountStatement> balances = balanceCalculator.calculateBalances(transactions);
        reverse(balances);
        for (AccountStatement statement : balances) {
            console.printLine(statement.toString());
        }
    }
}
