package org.example;

// CalculatorServiceTest.java
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        // Arrange
        CalculatorService service = new CalculatorService();

        // Act
        int result = service.add(5, 7);

        // Assert
        assertEquals(12, result);
    }
}
