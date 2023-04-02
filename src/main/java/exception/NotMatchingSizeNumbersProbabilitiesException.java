package exception;

public class NotMatchingSizeNumbersProbabilitiesException extends RuntimeException {

    public NotMatchingSizeNumbersProbabilitiesException() {
        super("Not matching size, input of random numbers length not equal to probabilities length");
    }
}
