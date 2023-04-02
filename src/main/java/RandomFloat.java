import java.util.Random;

public class RandomFloat {

    private final Random random;

    public RandomFloat() {
        random = new Random();
    }

    public float nextFloat() {
        return random.nextFloat();
    }
}
