package de.egga.mockist.transactions;

/**
 * @author egga
 */
public class Withdrawal extends Transaction {

    private final int amount;

    public Withdrawal(String date, int amount) {
        super(date);
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return -amount;
    }
}
