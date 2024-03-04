import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserRequestAPI {
    @Test
    public void testSetInputSource() {
        UserRequestAPI request = new UserRequest(new FileInputConfig("input.txt"), new FileOutputConfig(null), ';');
        assertEquals("input.txt", request.getFileInputPath());
    }

    @Test
    public void testSetOutputDestination() {
        UserRequestAPI request = new UserRequest(new FileInputConfig(null), new FileOutputConfig("output.txt"), ';');
        assertEquals("output.txt", request.getFileOutputPath());
    }

    @Test
    public void testSetDelimiter() {
        UserRequestAPI request = new UserRequest(new FileInputConfig(null), new FileOutputConfig(null));
        request.setDelimiter(',');
        assertEquals(',', request.getDelimiter());
    }

    @Test
    public void testSetDefaultDelimiter() {
        UserRequestAPI request = new UserRequest(new FileInputConfig(null), new FileOutputConfig(null));
        assertEquals(';', request.getDelimiter());
    }

    @Test
    public void testCheckJobStatus() {
        UserRequestAPI request = new UserRequest(new FileInputConfig("input.txt"), new FileOutputConfig("output.txt"), ';');
        assertEquals(JobStatus.JobStatusCheck.FAILURE, request.checkJobStatus());
    }
}
