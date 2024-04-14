import dataengine.DataEngine;
import dataengine.DataEngineAPI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestDataEngineAPI {
    @Test
    public void testReadData() {

        File mockFile = Mockito.mock(File.class);
        Scanner mockScanner = Mockito.mock(Scanner.class);

        when(mockFile.exists()).thenReturn(true);
        when(mockFile.isFile()).thenReturn(true);
        when(mockScanner.nextLine()).thenReturn("1,2,3", "4,5,6", "").thenReturn(String.valueOf(false));

        DataEngineAPI dataEngine = new DataEngine();

        DataEngineAPI.EngineStatus status = dataEngine.readData("inputSource").getEngineStatus();

        assertEquals(DataEngineAPI.EngineStatus.FILE_NOT_FOUND, status);
    }

    @Test
    public void testWriteData() throws IOException {
        File mockFile = Mockito.mock(File.class);
        FileWriter mockFileWriter = Mockito.mock(FileWriter.class);
        List<String> testData = new ArrayList<>();
        testData.add("test data");

        DataEngineAPI dataEngine = new DataEngine();

        DataEngineAPI.EngineStatus status = dataEngine.writeData("outputDestination", testData);

        assertEquals(DataEngineAPI.EngineStatus.NO_ERROR, status);
    }
}
