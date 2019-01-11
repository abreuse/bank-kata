package fr.alexis.breuse.account;

import fr.alexis.breuse.exception.NegativeAmountException;
import fr.alexis.breuse.exception.NotEnoughFundsException;
import fr.alexis.breuse.operation.Operation;
import fr.alexis.breuse.operation.OperationFactory;
import fr.alexis.breuse.operation.OperationType;

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

    public Account deposit(double amount) throws NegativeAmountException {
        if(amount < 0)
            throw new NegativeAmountException();

        this.balance += amount;
        operations.add(OperationFactory.createOperation(OperationType.DEPOSIT, this.balance, amount));

        return this;
    }

    public Account withdraw(double amount) throws NotEnoughFundsException, NegativeAmountException {
        if(amount < 0)
            throw new NegativeAmountException();

        if(amount > balance)
            throw new NotEnoughFundsException("The amount [" + amount + "]"
                    + " to withdraw is greater than the current balance [" + balance + "].");

        this.balance -= amount;
        operations.add(OperationFactory.createOperation(OperationType.WITHDRAW, this.balance, amount));

        return this;
    }

    public void printOperations() {
        System.out.println("DATE\t\t|\tTYPE\t|\tAMOUNT\t|\tBALANCE");
        for (Operation operation : operations) {
            System.out.println(operation);
        }
    }
}
