import org.junit.jupiter.api.Test;
import usercompute.ComputeEngine;

import java.io.IOException;

public class ComputeEngineIntegrationTest {
    public ComputeEngine computeEngine = new ComputeEngine();
    public TestDataEngineAPI dataEngine = new TestDataEngineAPI();

    @Test
    public void testComputeEngineIntegration() throws IOException {
        int[] input = {1, 10, 25};
        //InMemoryImpInputConfig inputConfig = new InMemoryImpInputConfig(inputData);
        InMemoryImpOutputConfig outputConfig = new InMemoryImpOutputConfig();

        computeEngine.findFactors(input);

        String outputData = outputConfig.getOutputSource();
    }
}
