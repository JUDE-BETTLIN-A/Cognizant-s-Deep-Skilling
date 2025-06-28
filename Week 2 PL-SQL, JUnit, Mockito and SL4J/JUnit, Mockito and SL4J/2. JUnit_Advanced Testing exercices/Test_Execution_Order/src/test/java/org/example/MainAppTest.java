package org.example;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainAppTest {

    MainApp app = new MainApp();

    @Test
    public void testA_add() {
        assertEquals(5, app.add(2, 3));
    }

    @Test
    public void testB_multiply() {
        assertEquals(6, app.multiply(2, 3));
    }

    @Test
    public void testC_isEven() {
        assertTrue(app.isEven(4));
        assertFalse(app.isEven(3));
    }
}
