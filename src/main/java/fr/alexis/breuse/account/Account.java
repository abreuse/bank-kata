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


    public Account deposit(double amount) {
        validateAmount(amount);

        this.balance += amount;
        operations.addFirst(OperationFactory.createDepositOperation(this.balance, amount));

        return this;
    }


    public Account withdraw(double amount){
        validateAmount(amount);
        validateBalance(amount);

        this.balance -= amount;
        operations.addFirst(OperationFactory.createWithdrawOperation(this.balance, amount));

        return this;
    }


    private void validateAmount(double amount) {
        if(amount < 0)
            throw new NegativeAmountException();
    }


    private void validateBalance(double amount) {
        if(amount > balance)
            throw new NotEnoughFundsException("The amount [" + amount + "]"
                    + " to withdraw is greater than the current balance [" + balance + "].");
    }


    public void printOperations() {
        System.out.println("DATE\t\t|\tTYPE\t|\tAMOUNT\t|\tBALANCE");
        operations.forEach(System.out::println);
    }


}
