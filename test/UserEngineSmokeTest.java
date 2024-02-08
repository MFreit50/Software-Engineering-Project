import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class TestUserEngineAPI{
    public void testUserEngine() throws Exception{
        UserEngineAPI mockUserEngine = Mockito.mock(UserEngineAPI.class);
        UserEngineAPI testUserEngine = new UserEngineAPI(mockUserEngine);
    }
}