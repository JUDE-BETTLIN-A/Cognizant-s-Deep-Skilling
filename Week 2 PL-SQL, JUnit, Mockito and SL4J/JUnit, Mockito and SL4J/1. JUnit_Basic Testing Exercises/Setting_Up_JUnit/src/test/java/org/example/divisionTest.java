package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class divisionTest {

    @Test
    public void testDiviWithValidInput() {
        division d = new division();
        int result = d.divi(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDiviWithZeroNumerator() {
        division d = new division();
        int result = d.divi(0, 5);
        assertEquals(0, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDiviByZero() {
        division d = new division();
        d.divi(5, 0);
    }
}
