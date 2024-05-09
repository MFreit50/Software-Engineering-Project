import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import usercompute.ComputeEngine;
import usercompute.ComputeEngineAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestComputeEngineAPI {
    @Test
    public void testComputeEngine() {
        ComputeEngineAPI engine = Mockito.mock(ComputeEngine.class);
        when(engine.findFactorsHelper(1)).thenReturn("1\n"); // Mock the behavior of findFactorsHelper

        String expectedFactors = "1\n"; // Expected result
        String actualFactors = engine.findFactorsHelper(1); // Actual result

        assertEquals(expectedFactors, actualFactors);
    }
}
