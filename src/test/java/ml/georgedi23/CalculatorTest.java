package ml.georgedi23;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void addNumbersWithNewlineSeparator(){
        //Given
        String given = "1\n2,3\n4,5\n6,7,8\n9,45";
        int expected = 90;

        //When
        int actual = calc.add(given);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void providedDelimiter(){
        //Given
        String given = "//;\n1;2";
        int expected = 3;

        //When
        int actual = calc.add(given);

        //Then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void singleNegativeTest(){
        //Given
        String given = "//;\n1;-2";

        //When
        int actual = calc.add(given);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doubleNegativeTest(){
        //Given
        String given = "//;\n-1;-2";

        //When
        int actual = calc.add(given);
    }

    @Test
    public void singleNegativeMessageTest() throws Exception{
        //Given
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("negatives not allowed: [-1]");
        String given = "//;\n-1;2";

        //When
        int actual = calc.add(given);
    }

    @Test
    public void doubleNegativeMessageTest() throws Exception{
        //Given
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("negatives not allowed: [-1, -2]");
        String given = "//;\n-1;-2";

        //When
        int actual = calc.add(given);
    }

    @Test
    public void mixedNegativeMessageTest() throws Exception{
        //Given
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("negatives not allowed: [-1, -3]");
        String given = "//;\n-1;2;-3";

        //When
        int actual = calc.add(given);
    }
}