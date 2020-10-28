package ml.georgedi23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test
    public void addTwoTest(){
        //Given
        String given = "1,2";
        int expected = 3;

        //When
        int actual = calc.add(given);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void addOneTest(){
        //Given
        String given = "1";
        int expected = 1;

        //When
        int actual = calc.add(given);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void addEmptyTest(){
        //Given
        String given = "";
        int expected = 0;

        //When
        int actual = calc.add(given);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void addUnknownAmountOfNumbers(){
        //Given
        String given = "1,2,3,4,5,6,7,8,9,45";
        int expected = 90;

        //When
        int actual = calc.add(given);

        //Then
        assertEquals(expected, actual);
    }
}