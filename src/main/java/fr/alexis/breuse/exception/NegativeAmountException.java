package fr.alexis.breuse.exception;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException() {
        super("A negative amount can't be deposit or withdraw.");
    }
}
