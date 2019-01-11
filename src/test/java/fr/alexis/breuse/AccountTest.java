package fr.alexis.breuse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void init() {
        account = new Account(100);
    }

    @Test
    public void should_deposit_100() throws NegativeDepositAmountException {
        account.deposit(100);
        assertEquals(200, account.getBalance(), 0);
    }

    @Test
    public void should_deposit_10_45() throws NegativeDepositAmountException {
        account.deposit(10.45);
        assertEquals(110.45, account.getBalance(), 0);
    }

    @Test(expected = NegativeDepositAmountException.class)
    public void should_throw_exception_when_deposit_negative_amount() throws NegativeDepositAmountException {
        account.deposit(-100);
    }

    @Test
    public void should_withdraw_100() throws NotEnoughFundsException {
        account.withdraw(100);
        assertEquals(0, account.getBalance(), 0);
    }

    @Test
    public void should_withdraw_10_45() throws NotEnoughFundsException {
        account.withdraw(10.45);
        assertEquals(89.55, account.getBalance(), 0);
    }

    @Test(expected = NotEnoughFundsException.class)
    public void should_throw_exception_when_withdraw_more_than_balance() throws NotEnoughFundsException {
        account.withdraw(150);
    }
}
