package de.egga.classicist;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private final InMemoryConsoleOutput console = new InMemoryConsoleOutput();
    private final TestClock clock = new TestClock("01/01/2015");

    private final Account account = new Account(console, clock);

    @Test
    public void itShouldPrintAnEmptyStatement() {
        account.printStatement();
        assertThat(console.getOutput()).containsOnly("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void itShouldDeposit() {
        account.deposit(500);
        account.printStatement();
        assertThat(console.getOutput()).containsOnly(
                "DATE | AMOUNT | BALANCE",
                "01/01/2015 | 500 | 500"
        );
    }

    @Test
    public void itShouldHandleTwoDeposits() {
        account.deposit(500);
        account.deposit(500);
        account.printStatement();
        assertThat(console.getOutput()).containsOnly(
                "DATE | AMOUNT | BALANCE",
                "01/01/2015 | 500 | 500",
                "01/01/2015 | 500 | 1000"
        );
    }

    @Test
    public void itShouldHandleDepositsOnDifferentDates() {
        account.deposit(500);
        clock.setDate("02/01/2015");
        account.deposit(500);
        account.printStatement();
        assertThat(console.getOutput()).containsOnly(
                "DATE | AMOUNT | BALANCE",
                "01/01/2015 | 500 | 500",
                "02/01/2015 | 500 | 1000"
        );
    }
}