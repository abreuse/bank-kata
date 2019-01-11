package fr.alexis.breuse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NegativeDepositAmountException, NotEnoughFundsException {
        Account account = new Account(100);
        account.deposit(100);
        account.withdraw(50);
        account.printOperations();
    }
}
