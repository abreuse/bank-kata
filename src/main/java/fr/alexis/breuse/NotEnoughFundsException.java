package fr.alexis.breuse;

public class NotEnoughFundsException extends Throwable {
    public NotEnoughFundsException(String message) {
        super(message);
    }
}
