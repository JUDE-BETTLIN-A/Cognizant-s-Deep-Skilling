package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalciTest {

    Calci calc = new Calci();

    @Test
    public void testAdd() {
        int result = calc.add(2, 3);
        assertEquals(5, result);
        assertTrue(result > 4);
        assertFalse(result < 4);
    }

    @Test
    public void testSubtract() {
        int result = calc.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        int result = calc.multiply(3, 5);
        assertEquals(15, result);
    }

    @Test
    public void testDivide() {
        int result = calc.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(5, 0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    public void testNullChecks() {
        String value = null;
        Object obj = new Object();

        assertNull(value);
        assertNotNull(obj);
    }
}
