package fr.alexis.breuse.operation;

import java.util.Date;

public class OperationFactory {

    public static Operation createDepositOperation(double balance, double amount) {
        return new Operation(new Date(), OperationType.DEPOSIT, balance, amount);
    }

    public static Operation createWithdrawOperation(double balance, double amount) {
        return new Operation(new Date(), OperationType.WITHDRAW, balance, amount);
    }
}
