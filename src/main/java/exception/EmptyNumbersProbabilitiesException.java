package exception;

public class EmptyNumbersProbabilitiesException extends RuntimeException{

    public EmptyNumbersProbabilitiesException() {
        super("Input of random numbers or probabilities can not be empty");
    }
}
