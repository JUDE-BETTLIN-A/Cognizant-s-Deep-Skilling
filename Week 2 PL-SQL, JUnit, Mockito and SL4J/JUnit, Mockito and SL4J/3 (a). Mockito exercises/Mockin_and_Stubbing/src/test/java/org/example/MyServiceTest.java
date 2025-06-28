package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock into service and test
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert the result
        assertEquals("Mock Data", result);
    }
}
