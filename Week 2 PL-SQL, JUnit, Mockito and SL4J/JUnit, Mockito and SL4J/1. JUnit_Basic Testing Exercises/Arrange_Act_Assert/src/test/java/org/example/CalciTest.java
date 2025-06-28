package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalciTest {

    private Calci calci;

    @Before
    public void setUp() {
        // Setup (runs before each test)
        calci = new Calci();
        System.out.println("Setup completed");
    }

    @After
    public void tearDown() {
        // Teardown (runs after each test)
        calci = null;
        System.out.println("Teardown completed");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 7;

        // Act
        int result = calci.add(a, b);

        // Assert
        assertEquals(12, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = calci.subtract(a, b);

        // Assert
        assertEquals(7, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 6;
        int b = 4;

        // Act
        int result = calci.multiply(a, b);

        // Assert
        assertEquals(24, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 20;
        int b = 5;

        // Act
        int result = calci.divide(a, b);

        // Assert
        assertEquals(4, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        // Act
        calci.divide(10, 0);
    }
}
