import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ComputeEngineIntegrationTest {
    public ComputeEngine computeEngine = new ComputeEngine();
    public TestDataEngineAPI dataEngine = new TestDataEngineAPI();

    @Test
    public void testComputeEngineIntegration() throws IOException {
        List<Integer> inputData = Arrays.asList(1, 10, 25);
        InMemoryImpInputConfig inputConfig = new InMemoryImpInputConfig(inputData);
        InMemoryImpOutputConfig outputConfig = new InMemoryImpOutputConfig();

        for (Integer input : inputData) {
            computeEngine.computeProcess(input);
        }

        String outputData = outputConfig.getOutputSource();
    }
}
