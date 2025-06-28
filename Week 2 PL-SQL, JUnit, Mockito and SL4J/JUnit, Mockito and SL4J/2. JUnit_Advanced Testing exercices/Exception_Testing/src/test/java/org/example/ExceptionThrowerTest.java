package org.example;
import org.junit.Test;

public class ExceptionThrowerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testThrowException() {
        ExceptionThrower et = new ExceptionThrower();
        et.throwException();  // should throw IllegalArgumentException
    }
}
