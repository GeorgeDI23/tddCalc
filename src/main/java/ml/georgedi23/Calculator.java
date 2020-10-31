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
        if(checkForNegatives(numbersToAdd)){
            throw new IllegalArgumentException("negatives not allowed");
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

    private boolean checkForNegatives(int[] numbers){
        for(int number : numbers){
            if(number < 0){
                return true;
            }
        }
        return false;
    }
}
