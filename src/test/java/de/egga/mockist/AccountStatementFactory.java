package de.egga.mockist;

import de.egga.mockist.transactions.AccountStatement;

/**
 * @author egga
 */
public class AccountStatementFactory {

    public static AccountStatement defaultStatement() {
        return new AccountStatement("", "", "");
    }
}
