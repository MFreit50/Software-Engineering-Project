import org.mockito.Mockito;
import org.junit.Test;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class TestDataEngineAPI {
    @Test
    public void testDataEngine() throws Exception{
        InputSource inputSource = Mockito.mock(InputSource.class);

        DataEngine dataEngine = new DataEngine();

        dataEngine.readData(inputSource);
        dataEngine.writeData(null, "");

    }
}
