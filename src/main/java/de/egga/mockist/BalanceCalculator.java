package de.egga.mockist;

import de.egga.mockist.transactions.AccountStatement;
import de.egga.mockist.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author egga
 */
public class BalanceCalculator {

    public List<AccountStatement> calculateBalances(List<Transaction> transactions) {
        List<AccountStatement> statements = new ArrayList<>();

        Integer currentBalance = 0;
        for (Transaction transaction : transactions) {
            Integer amount = transaction.getAmount();
            currentBalance += amount;
            AccountStatement statement = new AccountStatement(transaction.date, amount, currentBalance);
            statements.add(statement);
        }

        return statements;
    }
}
