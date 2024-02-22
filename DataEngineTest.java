import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataEngineTest {
    @Test
    public void testFileReadFormat() throws IOException {
        File inputFile = File.createTempFile("Not_Integers.txt", "Hello, World");

        DataEngine dataEngine = new DataEngine();

        dataEngine.setInputSource(inputFile.getPath());

        DataEngine.EngineStatus engineStatus = dataEngine.readData(inputFile.getPath());

        assertEquals(DataEngineAPI.EngineStatus.FILE_READ_ERROR, engineStatus);
    }
}

