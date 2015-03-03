package de.egga.mockicist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static de.egga.mockicist.TransactionFactory.*;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountAcceptanceTest {

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    DateProvider dateProvider;
    @Mock
    ConsolePrinter console;

    private Account account;

    @Before
    public void setUp() throws Exception {
        StatementPrinter statementPrinter = new StatementPrinter(console, new BalanceCalculator());
        account = new Account(transactionRepository, dateProvider, statementPrinter);
    }

    @Test
    public void should_print_statement_containing_all_transactions() throws Exception {
        when(transactionRepository.getTransactions()).thenReturn(asList(highDeposit(), defaultWithdrawal(), defaultDeposit()));

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        verify(console).printLine("DATE | AMOUNT | BALANCE");
        verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}