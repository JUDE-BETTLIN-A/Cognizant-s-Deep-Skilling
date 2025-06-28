package org.example;


import org.junit.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Create service and call method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify interaction with specific method
        verify(mockApi).getData();
    }
}
