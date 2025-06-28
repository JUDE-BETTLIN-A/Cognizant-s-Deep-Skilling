package org.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // Step 1: Create a mock network client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // Step 2: Stub the connect() method
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // Step 3: Inject mock into the service
        NetworkService networkService = new NetworkService(mockNetworkClient);

        // Step 4: Verify the logic
        String result = networkService.connectToServer();
        assertEquals("Connected to Mock Connection", result);

        // Optional: Verify interaction
        verify(mockNetworkClient).connect();
    }
}
