import org.junit.Assert;
import org.junit.Test;

public class TestComputeEngineAPI {
    @Test
    public void testComputeEngine() throws Exception {
        ComputeEngineAPI engine = new ComputeEngine();
        Assert.assertEquals(1, engine.computeProcess(1));
    }
}
