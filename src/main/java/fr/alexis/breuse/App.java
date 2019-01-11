package fr.alexis.breuse;

import fr.alexis.breuse.account.Account;
import fr.alexis.breuse.exception.NegativeDepositAmountException;
import fr.alexis.breuse.exception.NotEnoughFundsException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NegativeDepositAmountException, NotEnoughFundsException {
        Account account = new Account(100);
        account.deposit(100)
                .withdraw(50)
                .deposit(25)
                .withdraw(30)
                .printOperations();
    }
}
