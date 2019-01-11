package fr.alexis.breuse;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws NegativeDepositAmountException {
        if(amount < 0)
            throw new NegativeDepositAmountException();

        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws NotEnoughFundsException {
        if(amount > balance)
            throw new NotEnoughFundsException("The amount [" + amount + "]"
                    + " to withdraw is greater than the current balance [" + balance + "].");

        this.balance -= amount;
    }
}
