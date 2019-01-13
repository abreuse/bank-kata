package fr.alexis.breuse.account;

import fr.alexis.breuse.exception.NegativeAmountException;
import fr.alexis.breuse.exception.NotEnoughFundsException;
import fr.alexis.breuse.operation.Operation;
import fr.alexis.breuse.operation.OperationFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Account {

    private double balance;

    private LinkedList<Operation> operations;

    private Predicate<Double> isNegativeValue = d -> d < 0;

    private Predicate<Double> isGreaterThanBalance = d -> d > this.balance;


    public Account(double balance) {
        this.balance = balance;
        operations = new LinkedList<>();
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
        operations.addFirst(OperationFactory.createDepositOperation(this.balance, amount));

        return this;
    }


    public Account withdraw(double amount) throws NotEnoughFundsException, NegativeAmountException {
        validateAmount(amount);
        validateBalance(amount);

        this.balance -= amount;
        operations.addFirst(OperationFactory.createWithdrawOperation(this.balance, amount));

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
        operations.forEach(System.out::println);
    }


}
