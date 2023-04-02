import exception.EmptyNumbersProbabilitiesException;
import exception.NotMatchingSizeNumbersProbabilitiesException;
import exception.ProbabilitiesDefinitionException;

import java.util.Arrays;

public class RandomGen {

    private final int[] randomNumbers;

    private final double[] probabilities;

    private final RandomFloat randomFloat;

    private static final double PROBABILITY_SUM_THRESHOLD = 1.02;

    public RandomGen(int[] randomNumbers, double[] probabilities, RandomFloat randomFloat) {
        this.randomNumbers = randomNumbers;
        this.probabilities = probabilities;
        this.randomFloat = randomFloat;
    }

    public int nextNum() {
        validateInput();

        float currentCall = randomFloat.nextFloat();
        float sum = 0;
        // iterate over probabilities values and find matching random number
        for (int i = 0; i < probabilities.length; i++) {
            sum += probabilities[i];
            if (currentCall <= sum) {
                return randomNumbers[i];
            }
        }
        return 0;
    }

    private void validateInput() {
        // validate input for non-zero random numbers or probabilities
        if (randomNumbers.length == 0 || probabilities.length == 0) {
            throw new EmptyNumbersProbabilitiesException();
        }
        // validate input for matching random number and their probabilities
        if (randomNumbers.length != probabilities.length) {
            throw new NotMatchingSizeNumbersProbabilitiesException();
        }
        // validate probabilities definition sum matching 100%
        if (Arrays.stream(probabilities).sum() > PROBABILITY_SUM_THRESHOLD) {
            throw new ProbabilitiesDefinitionException();
        }
        // probability value must be zero or positive check can be added too...
    }
}
