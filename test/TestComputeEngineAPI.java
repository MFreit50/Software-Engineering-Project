import org.junit.Assert;
import org.junit.Test;
import usercompute.ComputeEngine;
import usercompute.ComputeEngineAPI;

public class TestComputeEngineAPI {
    @Test
    public void testComputeEngine() throws Exception {
        ComputeEngineAPI engine = new ComputeEngine();
        Assert.assertEquals(1, engine.findFactorsHelper(1));
    }
}
