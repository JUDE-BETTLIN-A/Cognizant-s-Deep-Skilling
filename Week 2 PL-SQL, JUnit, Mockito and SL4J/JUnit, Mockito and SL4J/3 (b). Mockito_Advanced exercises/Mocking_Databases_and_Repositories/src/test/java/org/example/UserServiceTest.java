package org.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void testGetUserNameById() {
        // Step 1: Create mock repository
        UserRepository mockRepo = mock(UserRepository.class);

        // Step 2: Stub method
        when(mockRepo.findById(1L)).thenReturn(new User(1L, "Alice"));

        // Step 3: Inject into service
        UserService userService = new UserService(mockRepo);

        // Step 4: Call method and assert
        String name = userService.getUserNameById(1L);
        assertEquals("Alice", name);

        // Optional: verify interaction
        verify(mockRepo).findById(1L);
    }
}
