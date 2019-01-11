package fr.alexis.breuse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    @Test
    public void should_add_deposit_operation() {
        Account account = new Account(100);
        account.getOperations().add(OperationFactory.createOperation(OperationType.DEPOSIT, account.getBalance(), 50));

        assertEquals(1, account.getOperations().size());
    }
}
