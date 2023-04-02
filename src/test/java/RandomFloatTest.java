import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomFloatTest {

    @Test
    void nextFloat() {
        // arrange
        RandomFloat randomFloat = new RandomFloat();
        // act
        float result = randomFloat.nextFloat();
        // assert
        Assertions.assertTrue(result >= 0 && result < 1);
    }
}