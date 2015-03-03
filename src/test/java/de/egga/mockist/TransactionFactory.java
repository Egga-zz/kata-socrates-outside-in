package de.egga.mockist;

import de.egga.mockist.transactions.Deposit;
import de.egga.mockist.transactions.Transaction;
import de.egga.mockist.transactions.Withdrawal;

public class TransactionFactory {

    public static Transaction defaultTransaction() {
        return defaultDeposit();
    }

    public static Transaction defaultDeposit() {
        int amount = 500;
        String date = "10/04/2014";
        return new Deposit(date, amount);
    }
    public static Transaction highDeposit() {
        int amount = 1000;
        String date = "01/04/2014";
        return new Deposit(date, amount);
    }
    public static Transaction defaultWithdrawal() {
        int amount = 100;
        String date = "02/04/2014";
        return new Withdrawal(date, amount);
    }
}