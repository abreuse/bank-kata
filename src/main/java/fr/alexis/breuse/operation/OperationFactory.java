package fr.alexis.breuse.operation;

import java.util.Date;

public class OperationFactory {

    public static Operation createOperation(OperationType type, double balance, double amount) {
        return new Operation(new Date(), type, balance, amount);
    }
}
