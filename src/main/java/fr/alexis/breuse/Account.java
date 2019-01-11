package fr.alexis.breuse;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double depositAmount) throws NegativeDepositAmountException {
        if(depositAmount < 0)
            throw new NegativeDepositAmountException();

        this.balance += depositAmount;
    }

    public double getBalance() {
        return balance;
    }
}
