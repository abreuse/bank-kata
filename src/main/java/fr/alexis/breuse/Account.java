package fr.alexis.breuse;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;

    private List<Operation> operations;

    public Account(double balance) {
        this.balance = balance;
        operations = new ArrayList<Operation>();
    }

    public double getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void deposit(double amount) throws NegativeDepositAmountException {
        if(amount < 0)
            throw new NegativeDepositAmountException();

        this.balance += amount;
        operations.add(OperationFactory.createOperation(OperationType.DEPOSIT, this.balance, amount));
    }

    public void withdraw(double amount) throws NotEnoughFundsException {
        if(amount > balance)
            throw new NotEnoughFundsException("The amount [" + amount + "]"
                    + " to withdraw is greater than the current balance [" + balance + "].");

        this.balance -= amount;
        operations.add(OperationFactory.createOperation(OperationType.WITHDRAW, this.balance, amount));
    }

    public void printOperations() {
        System.out.println("DATE\t\t|\tTYPE\t|\tAMOUNT\t|\tBALANCE");
        for (Operation operation : operations) {
            System.out.println(operation);
        }
    }
}
