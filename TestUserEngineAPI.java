import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserEngineAPI {
    @Test
    public void testSetInputSource() {
        UserEngineAPI userEngine = new UserEngine();
        userEngine.setInputSource("input.txt");
        assertEquals("input.txt", userEngine.getInputSource());
    }

    @Test
    public void testSetOutputDestination() {
        UserEngineAPI userEngine = new UserEngine();
        userEngine.setOutputDestination("output.txt");
        assertEquals("output.txt", userEngine.getOutputDestination());
    }

    @Test
    public void testSetDelimiter() {
        UserEngineAPI userEngine = new UserEngine();
        userEngine.setDelimiter(",");
        assertEquals(",", userEngine.getDelimiter());
    }

    @Test
    public void testSetDefaultDelimiter() {
        UserEngineAPI userEngine = new UserEngine();
        userEngine.setDefaultDelimiter();
        assertEquals(";", userEngine.getDelimiter());
    }

    @Test
    public void testCheckJobStatus() {
        UserEngineAPI userEngine = new UserEngine();
        assertEquals(JobStatus.JobStatusCheck.FAILURE, userEngine.checkJobStatus());
    }
}
