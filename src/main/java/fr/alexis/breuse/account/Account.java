package fr.alexis.breuse.account;

import fr.alexis.breuse.exception.NegativeAmountException;
import fr.alexis.breuse.exception.NotEnoughFundsException;
import fr.alexis.breuse.operation.Operation;
import fr.alexis.breuse.operation.OperationFactory;
import fr.alexis.breuse.operation.OperationType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Account {

    private double balance;

    private List<Operation> operations;

    private Predicate<Double> isNegativeValue = d -> d < 0;

    private Predicate<Double> isGreaterThanBalance = d -> d > this.balance;


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
        validateAmount(amount);

        this.balance += amount;
        operations.add(OperationFactory.createOperation(OperationType.DEPOSIT, this.balance, amount));

        return this;
    }


    public Account withdraw(double amount) throws NotEnoughFundsException, NegativeAmountException {
        validateAmount(amount);
        validateBalance(amount);

        this.balance -= amount;
        operations.add(OperationFactory.createOperation(OperationType.WITHDRAW, this.balance, amount));

        return this;
    }


    private void validateAmount(double amount) throws NegativeAmountException {
        if(isNegativeValue.test(amount))
            throw new NegativeAmountException();
    }


    private void validateBalance(double amount) throws NotEnoughFundsException {
        if(isGreaterThanBalance.test(amount))
            throw new NotEnoughFundsException("The amount [" + amount + "]"
                    + " to withdraw is greater than the current balance [" + balance + "].");
    }


    public void printOperations() {
        System.out.println("DATE\t\t|\tTYPE\t|\tAMOUNT\t|\tBALANCE");
        for (Operation operation : operations) {
            System.out.println(operation);
        }
    }


}
