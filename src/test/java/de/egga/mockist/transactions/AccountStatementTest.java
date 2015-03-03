package de.egga.mockist.transactions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountStatementTest {

    @Test
    public void it_should_serialize_entry() {
        AccountStatement statement = new AccountStatement("01/01/2015", "-500", "0");
        assertThat(statement.toString()).isEqualTo("01/01/2015 | -500 | 0");
    }
}