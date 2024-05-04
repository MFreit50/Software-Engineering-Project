import org.junit.jupiter.api.Test;
import usercompute.ComputeEngine;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ComputeEngineIntegrationTest {
    public ComputeEngine computeEngine = new ComputeEngine();
    public TestDataEngineAPI dataEngine = new TestDataEngineAPI();

    @Test
    public void testComputeEngineIntegration() throws IOException {
        List<Integer> input = new LinkedList<>();
        input.add(1);
        input.add(10);
        input.add(25);
        //InMemoryImpInputConfig inputConfig = new InMemoryImpInputConfig(inputData);
        InMemoryImpOutputConfig outputConfig = new InMemoryImpOutputConfig();

        computeEngine.findFactors(input);

        String outputData = outputConfig.getOutputSource();
        System.out.println(outputData);
    }
}
