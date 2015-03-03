package de.egga.mockicist;

import de.egga.mockicist.transactions.AccountStatement;

/**
 * @author egga
 */
public class AccountStatementFactory {

    public static AccountStatement defaultStatement() {
        return new AccountStatement("", "", "");
    }
}
