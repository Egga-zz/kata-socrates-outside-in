package de.egga.mockist;

import de.egga.mockist.transactions.AccountStatement;
import de.egga.mockist.transactions.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static de.egga.mockist.TransactionFactory.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BalanceCalculatorTest {

    private final BalanceCalculator calculator = new BalanceCalculator();

    @Test
    public void it_should_return_empty_list_on_empty_list() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        List<AccountStatement> statements = calculator.calculateBalances(transactions);
        assertThat(statements).isEmpty();
    }

    @Test
    public void it_should_return_one_balance_if_one_transaction() {
        List<Transaction> transactions = asList(defaultTransaction());
        List<AccountStatement> statements = calculator.calculateBalances(transactions);
        assertThat(statements).hasSize(1);
    }

    @Test
    public void it_should_return_five_balances_if_five_transactions() {
        List<Transaction> transactions = asList(defaultTransaction(), defaultTransaction(), defaultTransaction(), defaultTransaction(), defaultTransaction());
        List<AccountStatement> statements = calculator.calculateBalances(transactions);
        assertThat(statements).hasSize(5);
    }

    @Test
    public void it_should_add_deposits() {
        List<Transaction> transactions = asList(defaultDeposit(), defaultDeposit());
        List<AccountStatement> statements = calculator.calculateBalances(transactions);
        assertThat(statements).extracting("balance").containsExactly("500.00", "1000.00");
    }

    @Test
    public void it_should_subtract_withdrawals() {
        List<Transaction> transactions = asList(defaultDeposit(), defaultWithdrawal());
        List<AccountStatement> statements = calculator.calculateBalances(transactions);
        assertThat(statements).extracting("balance").containsExactly("500.00", "400.00");
    }
}