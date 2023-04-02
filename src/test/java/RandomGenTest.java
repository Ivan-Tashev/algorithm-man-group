import exception.EmptyNumbersProbabilitiesException;
import exception.NotMatchingSizeNumbersProbabilitiesException;
import exception.ProbabilitiesDefinitionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomGenTest {

    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new double[]{1., 0.}),
                Arguments.of(new int[]{1, 2}, new double[]{0.5, 0.5}),
                Arguments.of(new int[]{1, 2}, new double[]{0., 1.}));
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void nextNum(int[] randomNumbers, double[] probabilities) {
        // arrange
        RandomFloat randomFloat = Mockito.mock(RandomFloat.class);
        Mockito.when(randomFloat.nextFloat()).thenReturn((float) probabilities[0]);
        RandomGen randomGen = new RandomGen(randomNumbers, probabilities, randomFloat);
        // act
        int nextNum = randomGen.nextNum();
        // assert
        assertEquals(randomNumbers[0], nextNum);
    }

    @Test
    void nextNum_throwInvalidInputException() {
        int[] randomNumbers = {1};
        double[] probabilities = new double[0];
        RandomGen randomGen = new RandomGen(randomNumbers, probabilities, Mockito.mock(RandomFloat.class));

        assertThrows(EmptyNumbersProbabilitiesException.class, randomGen::nextNum);
    }

    @Test
    void nextNum_throwInvalidInputNumbersProbabilitiesException() {
        int[] randomNumbers = {1};
        double[] probabilities = {0.2, 0.3};
        RandomGen randomGen = new RandomGen(randomNumbers, probabilities, Mockito.mock(RandomFloat.class));

        assertThrows(NotMatchingSizeNumbersProbabilitiesException.class, randomGen::nextNum);
    }

    @Test
    void nextNum_throwProbabilitiesDefinitionException() {
        int[] randomNumbers = {1, 2};
        double[] probabilities = {0.5, 0.6};
        RandomGen randomGen = new RandomGen(randomNumbers, probabilities, Mockito.mock(RandomFloat.class));

        assertThrows(ProbabilitiesDefinitionException.class, randomGen::nextNum);
    }
}