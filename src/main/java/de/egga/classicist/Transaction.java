package de.egga.classicist;

/**
 * @author egga
 */
public class Transaction {

    private int amount;
    private String date;

    public Transaction(int i, String date) {
        amount = i;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
