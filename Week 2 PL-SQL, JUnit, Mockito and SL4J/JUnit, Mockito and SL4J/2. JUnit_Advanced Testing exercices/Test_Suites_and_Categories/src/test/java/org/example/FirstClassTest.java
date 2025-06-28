package org.example;

// FirstTest.java
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstClassTest {

    @Test
    public void testAlwaysTrue() {
        FirstClass fc = new FirstClass();
        assertTrue(fc.alwaysTrue());
    }
}
