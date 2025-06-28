package org.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        // Step 1: Create mocks
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);


        // Step 2: Stub the read method
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // Step 3: Use mock in service
        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();

        // Step 4: Assertions
        assertEquals("Processed Mock File Content", result);

        // Step 5: Verify write was called correctly
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
