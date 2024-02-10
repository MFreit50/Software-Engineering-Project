import org.mockito.Mockito;
import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class TestComputeEngineAPI {
    @Test
    public void testComputeEngine() throws Exception {
        Key key = Mockito.mock(Key.class);

        when(key.getKey()).thenReturn("Key");

        ComputeEngine computeEngine = new ComputeEngine();

        computeEngine.computeProcess(key);
    }
}
