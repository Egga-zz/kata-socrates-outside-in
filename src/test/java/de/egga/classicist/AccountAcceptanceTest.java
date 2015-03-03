package de.egga.classicist;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountAcceptanceTest {

    @Mock
    private StandardOutput console;

    @Test
    @Ignore
    public void it_should_print_statement_containing_all_transactions() {
        Account account = new Account(console, new TestClock(""));
        account.deposit(100);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        verify(console).printLine("DATE | AMOUNT | BALANCE");
        verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}