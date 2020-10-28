package ml.georgedi23;
import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {

    public Calculator() {
    }

    public Integer add(String numbers){
        if(numbers.isEmpty()) return 0;
        if(numbers.split(",").length == 1) return Integer.parseInt(numbers);
        int[] numbersToAdd = Stream.of(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(numbersToAdd).sum();
    }
}
