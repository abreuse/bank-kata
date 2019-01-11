package fr.alexis.breuse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    private Account account;

    @Before
    public void init() {
        account = new Account(100);
    }

    @Test
    public void should_add_deposit_operation() {
        account.getOperations().add(OperationFactory.createOperation(OperationType.DEPOSIT, account.getBalance(), 50));

        assertEquals(1, account.getOperations().size());
    }

    @Test
    public void should_add_withdraw_operation() {
        account.getOperations().add(OperationFactory.createOperation(OperationType.WITHDRAW, account.getBalance(), 50));

        assertEquals(1, account.getOperations().size());
    }
}
