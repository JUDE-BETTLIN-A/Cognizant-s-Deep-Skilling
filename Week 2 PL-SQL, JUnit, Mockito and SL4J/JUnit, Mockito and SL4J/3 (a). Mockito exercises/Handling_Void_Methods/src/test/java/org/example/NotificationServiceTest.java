package org.example;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    public void testVoidMethodInteraction() {
        // Step 1: Create mock object
        Notifier mockNotifier = mock(Notifier.class);

        // Step 2: Stub the void method (optional if it just does nothing)
        doNothing().when(mockNotifier).send("Hello User");

        // Step 3: Use the mock
        NotificationService service = new NotificationService(mockNotifier);
        service.process();

        // Step 4: Verify the interaction
        verify(mockNotifier).send("Hello User");
    }
}
