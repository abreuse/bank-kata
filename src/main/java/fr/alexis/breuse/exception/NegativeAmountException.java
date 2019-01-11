package fr.alexis.breuse.exception;

public class NegativeAmountException extends Throwable {
    public NegativeAmountException() {
        super("A negative amount can't be deposit or withdraw.");
    }
}
