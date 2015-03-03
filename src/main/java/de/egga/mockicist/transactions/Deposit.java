package de.egga.mockicist.transactions;

/**
 * @author egga
 */
public class Deposit extends Transaction {

    private final int amount;

    public Deposit(String date, int amount) {
        super(date);
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
