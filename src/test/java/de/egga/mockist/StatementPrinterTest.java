package de.egga.mockist;

import de.egga.mockist.transactions.AccountStatement;
import de.egga.mockist.transactions.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static de.egga.mockist.AccountStatementFactory.defaultStatement;
import static de.egga.mockist.TransactionFactory.defaultTransaction;
import static java.util.Arrays.asList;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {


    private StatementPrinter statementPrinter;

    @Mock
    private ConsolePrinter console;

    @Mock
    BalanceCalculator balanceCalculator;

    @Before
    public void setUp() throws Exception {
        statementPrinter = new StatementPrinter(console, balanceCalculator);
    }


    @Test
    public void should_return_only_headline_on_empty_list() {
        statementPrinter.print(new ArrayList<>());
        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void should_return_line_for_each_transaction() {
        when(balanceCalculator.calculateBalances(anyList())).thenReturn(listOfTwoStatements());
        statementPrinter.print(listOfTwoTransactions());
        verify(console, times(3)).printLine(anyString());
    }

    @Test
    public void should_use_balance_calculator() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        statementPrinter.print(transactions);
        verify(balanceCalculator).calculateBalances(transactions);
    }

    private List<Transaction> listOfTwoTransactions() {
        return asList(defaultTransaction(), defaultTransaction());
    }

    private List<AccountStatement> listOfTwoStatements() {
        return asList(defaultStatement(),defaultStatement());
    }
}