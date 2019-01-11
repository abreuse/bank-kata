package fr.alexis.breuse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void init() {
        account = new Account(0);
    }

    @Test
    public void should_deposit_100() throws NegativeDepositAmountException {
        account.deposit(100);
        assertEquals(100, account.getBalance(), 0);
    }

    @Test
    public void should_deposit_10_45() throws NegativeDepositAmountException {
        account.deposit(10.45);
        assertEquals(10.45, account.getBalance(), 0);
    }

    @Test(expected = NegativeDepositAmountException.class)
    public void should_throw_exception_when_deposit_negative_amount() throws NegativeDepositAmountException {
        account.deposit(-100);
    }
}
