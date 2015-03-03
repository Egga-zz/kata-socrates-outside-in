package de.egga.mockist.transactions;

import java.text.DecimalFormat;

/**
 * @author egga
 */
public class AccountStatement {

    private static final String SEPARATOR = " | ";
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    private final String date;
    private final String amount;
    private final String balance;

    public AccountStatement(String date, Integer amount, Integer balance) {
        this(date, formatNumber(amount), formatNumber(balance));
    }

    public AccountStatement(String date, String amount, String balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    private static String formatNumber(Integer amount) {
        return DECIMAL_FORMAT.format(amount);
    }

    @Override
    public String toString() {
        return date + SEPARATOR + amount + SEPARATOR + balance;
    }
}
