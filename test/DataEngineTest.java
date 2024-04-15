import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import dataengine.DataEngineServiceImpl;
import dataengine.DataEngineService.DataEngineResponse;
import dataengine.DataEngineService.EngineStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataEngineTest {
    @Test
    public void testFileReadFormat() throws IOException {
        File inputFile = File.createTempFile("Not_Integers.txt", "Hello, World");

        DataEngineServiceImpl dataEngine = new DataEngineServiceImpl();
        DataEngineResponse dataEngineResponse = dataEngine.readData(inputFile.getPath());
        EngineStatus engineStatus = dataEngineResponse.getEngineStatus();

        assertEquals(EngineStatus.NO_ERROR, engineStatus);
    }
}

