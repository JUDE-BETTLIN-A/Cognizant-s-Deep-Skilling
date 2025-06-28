package org.example;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class EvenCheckerTest {

    private final int input;
    private final boolean expected;

    public EvenCheckerTest(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    // Provide parameters: {input, expectedOutput}
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {2, true},
                {4, true},
                {5, false},
                {7, false},
                {0, true},
                {-2, true},
                {-3, false}
        });
    }

    @Test
    public void testIsEven() {
        EvenChecker checker = new EvenChecker();
        assertEquals(expected, checker.isEven(input));
    }
}
