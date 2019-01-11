package fr.alexis.breuse;

import fr.alexis.breuse.account.Account;
import fr.alexis.breuse.exception.NegativeAmountException;
import fr.alexis.breuse.exception.NotEnoughFundsException;
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
    public void should_deposit_100() throws NegativeAmountException {
        account.deposit(100);
        assertEquals(200, account.getBalance(), 0);
    }

    @Test
    public void should_deposit_10_45() throws NegativeAmountException {
        account.deposit(10.45);
        assertEquals(110.45, account.getBalance(), 0);
    }

    @Test(expected = NegativeAmountException.class)
    public void should_throw_exception_when_deposit_negative_amount() throws NegativeAmountException {
        account.deposit(-100);
    }

    @Test
    public void should_withdraw_100() throws NotEnoughFundsException, NegativeAmountException {
        account.withdraw(100);
        assertEquals(0, account.getBalance(), 0);
    }

    @Test
    public void should_withdraw_10_45() throws NotEnoughFundsException, NegativeAmountException {
        account.withdraw(10.45);
        assertEquals(89.55, account.getBalance(), 0);
    }

    @Test(expected = NotEnoughFundsException.class)
    public void should_throw_exception_when_withdraw_more_than_balance() throws NotEnoughFundsException, NegativeAmountException {
        account.withdraw(150);
    }
}
