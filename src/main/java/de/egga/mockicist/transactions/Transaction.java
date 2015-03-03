package de.egga.mockicist.transactions;

/**
 * @author egga
 */
public abstract class Transaction {

    public final String date;

    protected Transaction(String date) {
        this.date = date;
    }

    public abstract int getAmount();
}
