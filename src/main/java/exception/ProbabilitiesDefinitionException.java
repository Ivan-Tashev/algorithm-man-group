package exception;

public class ProbabilitiesDefinitionException extends RuntimeException{

    public ProbabilitiesDefinitionException() {
        super("Probabilities definition sum should equal to 1 (100%)");
    }
}
