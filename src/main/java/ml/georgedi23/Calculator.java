package ml.georgedi23;

public class Calculator {

    public Calculator() {
    }

    public Integer add(String numbers){
        if(numbers.isEmpty()) return 0;
        if(numbers.split(",").length == 1) return Integer.parseInt(numbers);
        return null;
    }
}
