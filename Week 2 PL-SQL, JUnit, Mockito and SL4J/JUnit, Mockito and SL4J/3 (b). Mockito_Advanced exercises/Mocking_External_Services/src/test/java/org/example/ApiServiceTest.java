package org.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // Step 1: Create mock REST client
        RestClient mockRestClient = mock(RestClient.class);

        // Step 2: Stub REST client method
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Step 3: Inject mock into service
        ApiService apiService = new ApiService(mockRestClient);

        // Step 4: Call method and verify result
        String result = apiService.fetchData();
        assertEquals("Fetched Mock Response", result);

        // Optional: verify interaction
        verify(mockRestClient).getResponse();
    }
}
