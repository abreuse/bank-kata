package fr.alexis.breuse;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    @Test
    public void should_add_deposit_operation() {
        Account account = new Account(100);
        OperationManager operationManager = new OperationManager();
        operationManager.storeOperation(new Date(), OperationType.DEPOSIT, account.getBalance(), 50);

        assertEquals(1, account.getOperations().size());
    }
}
