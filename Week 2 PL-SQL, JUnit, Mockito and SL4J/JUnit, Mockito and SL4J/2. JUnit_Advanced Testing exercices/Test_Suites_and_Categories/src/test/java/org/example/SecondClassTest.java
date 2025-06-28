package org.example;

// SecondTest.java
import org.junit.Test;
import static org.junit.Assert.*;

public class SecondClassTest {

    @Test
    public void testAdd() {
        SecondClass sc = new SecondClass();
        assertEquals(7, sc.add(3, 4));
    }
}
