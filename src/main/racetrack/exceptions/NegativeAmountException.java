package racetrack.exceptions;

@SuppressWarnings("serial")
public class NegativeAmountException extends Exception {

    public NegativeAmountException() {
    }

    public NegativeAmountException(String msg) {
        super("Negative balance not valid.");
    }
}
