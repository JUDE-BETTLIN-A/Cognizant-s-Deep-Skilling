package org.example;

import org.junit.Test;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    // Test that performTask completes within 500 milliseconds
    @Test(timeout = 500)
    public void testPerformTaskTimeout() throws InterruptedException {
        // This should pass (sleep 300ms < 500ms timeout)
        tester.performTask(300);
    }

    // This test will fail (sleep 700ms > 500ms timeout)
    /*
    @Test(timeout = 500)
    public void testPerformTaskTimeoutFailure() throws InterruptedException {
        tester.performTask(700);
    }
    */
}
