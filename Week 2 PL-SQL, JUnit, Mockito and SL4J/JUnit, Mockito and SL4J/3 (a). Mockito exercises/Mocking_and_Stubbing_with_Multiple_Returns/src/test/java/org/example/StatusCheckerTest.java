package org.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class StatusCheckerTest {

    @Test
    public void testMultipleReturnValues() {
        // Step 1: Mock ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub getStatus() to return different values
        when(mockApi.getStatus()).thenReturn("LOADING").thenReturn("DONE");

        // Step 3: Use the mock in the service
        StatusChecker checker = new StatusChecker(mockApi);
        String result = checker.checkStatusTwice();

        // Assert
        assertEquals("LOADING -> DONE", result);

        // Optional: verify method was called twice
        verify(mockApi, times(2)).getStatus();
    }
}
