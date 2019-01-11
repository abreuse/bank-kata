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
    public void should_deposit_100() {
        account.deposit(100);
        assertEquals(100, account.getBalance(), 0);
    }
}
