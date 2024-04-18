import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import dataengine.DataEngine;
import dataengine.DataResult;
import dataengine.DataEngineAPI.EngineStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataEngineTest {
    @Test
    public void testFileReadFormat() throws IOException {
        //File inputFile = File.createTempFile("Not_Integers.txt", "Hello, World");
        String inputFile = "src/factors.txt";

        DataEngine dataEngine = new DataEngine();
        DataResult dataResult = dataEngine.readData(inputFile);
        EngineStatus engineStatus = dataResult.getEngineStatus();

        assertEquals(EngineStatus.NO_ERROR, engineStatus);
    }
}

