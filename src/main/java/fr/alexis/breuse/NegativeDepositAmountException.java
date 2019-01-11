package fr.alexis.breuse;

public class NegativeDepositAmountException extends Throwable {
    public NegativeDepositAmountException() {
        super("A negative amount can't be deposit.");
    }
}
