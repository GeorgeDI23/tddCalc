package ml.georgedi23;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculator {

    public Calculator() {
    }

    public Integer add(String numbers){
        if(numbers.isEmpty()) return 0;
        numbers = correctForDelimiter(numbers);
        int[] numbersToAdd = Stream.of(numbers.split(",|\n")).mapToInt(Integer::parseInt).toArray();
        if(checkForNegatives(numbersToAdd).length > 0){
            throw new IllegalArgumentException("negatives not allowed: " + Arrays.toString(checkForNegatives(numbersToAdd)));
        }
        return Arrays.stream(numbersToAdd).sum();
    }

    private String correctForDelimiter(String numbers){
        Pattern pattern = Pattern.compile("//(.)");
        Matcher matcher = pattern.matcher(numbers);
        if(matcher.find()) {
            numbers = numbers.substring(4);
            return numbers.replace(matcher.group(1), ",");
        }
        return numbers;
    }

    private int[] checkForNegatives(int[] numbers){
        int[] negativeInts = new int[0];
        for(int number : numbers){
            if(number < 0){
                negativeInts = Arrays.copyOf(negativeInts, negativeInts.length+1);
                negativeInts[negativeInts.length-1] = number;
            }
        }
        return negativeInts;
    }
}
