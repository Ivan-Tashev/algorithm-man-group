import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // example input data
        int[] randomNumbers = {-1, 0, 1, 2, 3};
        double[] probabilities = {0.01, 0.3, 0.58, 0.1, 0.01};

        RandomGen randomGen = new RandomGen(randomNumbers, probabilities, new RandomFloat());

        HashMap<Integer, Integer> result = new HashMap<>();

        /* This iteration over randomNumber is only for properly displaying the result
        for elements with 0 times probability
        It can be optimized with replacing it with one line
        result.putIfAbsent(num, 0) after line 26
        * */
        for (int randomNum : randomNumbers) {
            result.put(randomNum, 0);
        }

        // Example invocation of nextInt() method 100 times
        for (int i = 0; i < 100; i++) {
            int randomNumber = randomGen.nextNum();
            result.put(randomNumber, result.get(randomNumber) + 1);
        }

        /* Sort the result based on input order of random numbers
         * Output the result matching the style per requirement
         * */
        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " times"));
    }
}
