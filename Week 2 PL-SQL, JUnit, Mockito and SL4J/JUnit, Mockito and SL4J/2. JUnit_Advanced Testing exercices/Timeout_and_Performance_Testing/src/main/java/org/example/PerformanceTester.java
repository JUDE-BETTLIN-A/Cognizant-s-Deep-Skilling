package org.example;

public class PerformanceTester {
    // Simulate some task - here just sleep for given milliseconds
    public void performTask(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
