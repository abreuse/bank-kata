package fr.alexis.breuse.exception;

public class NegativeDepositAmountException extends Throwable {
    public NegativeDepositAmountException() {
        super("A negative amount can't be deposit.");
    }
}
