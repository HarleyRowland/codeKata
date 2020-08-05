package sessions.session1;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sessions.session1.StringCalculator;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void addShouldReturnZero(){
        assertEquals(stringCalculator.add(""), 0);
    }

    @Test
    public void shouldReturnSingleNumberStringIntValue(){
        assertEquals(stringCalculator.add("22"), 22);
        assertEquals(stringCalculator.add("8"), 8);
        assertEquals(stringCalculator.add("678"), 678);
    }

    @Test
    public void shouldReturnTheValueOfEachNumberAddedTogetherWhenNumbersAreSeparatedByAComma(){
        assertEquals(stringCalculator.add("10,20"), 30);
        assertEquals(stringCalculator.add("1,999"), 1000);
        assertEquals(stringCalculator.add("38,27"), 65);
    }

    @Test
    public void shouldReturnTheValueOfEachNumberAddedTogetherWhenNumbersAreSeparatedByANewLine(){
        assertEquals(stringCalculator.add("29\n93"), 122);
        assertEquals(stringCalculator.add("1\n2"), 3);
        assertEquals(stringCalculator.add("66\n33"), 99);
    }

    @Test
    public void shouldReturnTheValueOfEachNumberAddedTogetherWhenNumbersAreSeparatedByANewLineOrComma(){
        assertEquals(stringCalculator.add("1\n2,3\n4"), 10);
        assertEquals(stringCalculator.add("10\n26,2"), 38);
        assertEquals(stringCalculator.add("11,222\n999"), 1232);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowIllegalStateExceptionWhenNegativesPassed(){
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("negatives not allowed: -12, -123");
        stringCalculator.add("-12,73627\n-123");
    }

    @Test
    public void shouldOnlyAddPositiveNumbersLessThan1000(){
        assertEquals(stringCalculator.add("1\n2,99999,3\n4"), 10);
        assertEquals(stringCalculator.add("10\n26,1001"), 36);
        assertEquals(stringCalculator.add("1000,1000\n1000\n1001"), 3000);
    }

    @Test
    public void shouldBeAbleToPassOwnSingleCharacterDelimeterOnFirstLine(){
        assertEquals(stringCalculator.add("//#\n1#2#3#4"), 10);
        assertEquals(stringCalculator.add("//p\n10p26p2"), 38);
        assertEquals(stringCalculator.add("//x\n11x222x999"), 1232);
    }

    @Test
    public void shouldBeAbleToPassOwnMultiCharacterDelimeterOnFirstLine(){
        assertEquals(stringCalculator.add("//####\n1####2####3####4"), 10);
        assertEquals(stringCalculator.add("//abcdefg\n10abcdefg26abcdefg2"), 38);
        assertEquals(stringCalculator.add("//::::::::\n11::::::::222::::::::999"), 1232);
    }

}
