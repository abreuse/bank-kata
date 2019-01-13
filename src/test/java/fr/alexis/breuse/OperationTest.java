package fr.alexis.breuse;

import fr.alexis.breuse.account.Account;
import fr.alexis.breuse.operation.OperationFactory;
import fr.alexis.breuse.operation.OperationType;
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
        account.getOperations().add(OperationFactory.createDepositOperation(account.getBalance(), 50));

        assertEquals(1, account.getOperations().size());
        assertEquals(OperationType.DEPOSIT, account.getOperations().get(0).getType());
    }

    @Test
    public void should_add_withdraw_operation() {
        account.getOperations().add(OperationFactory.createWithdrawOperation(account.getBalance(), 50));

        assertEquals(1, account.getOperations().size());
        assertEquals(OperationType.WITHDRAW, account.getOperations().get(0).getType());
    }
}
