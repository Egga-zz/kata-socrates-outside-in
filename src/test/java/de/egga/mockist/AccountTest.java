package de.egga.mockist;


import de.egga.mockist.transactions.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static de.egga.mockist.TransactionFactory.defaultTransaction;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    private String date = "01/02/03";

    private Account account;

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private DateProvider dateProvider;
    @Mock
    private StatementPrinter statementPrinter;

    @Before
    public void setUp() {
        account = new Account(transactionRepository, dateProvider, statementPrinter);
    }

    @Test
    public void testDeposit() {
        when(dateProvider.getDate()).thenReturn(date);
        account.deposit(100);
        verify(transactionRepository).persist(100, date);
    }

    @Test
    public void testWithdraw() {
        when(dateProvider.getDate()).thenReturn(date);
        account.withdraw(100);
        verify(transactionRepository).persist(-100, date);
    }

    @Test
    public void testPrintStatement() {
        List<Transaction> transactions = asList(defaultTransaction());
        when(transactionRepository.getTransactions()).thenReturn(transactions);
        account.printStatement();
        verify(statementPrinter).print(transactions);
    }
}