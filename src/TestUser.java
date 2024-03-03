import java.io.File;
import java.io.IOException;


public class TestUser {
	
	// TODO 3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor
	private final Coordinator coordinator;

	public TestUser(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		
		// TODO 4: Call the appropriate method(s) on the coordinator to get it to 
		// run the compute job specified by inputPath, outputPath, and delimiter
		try {
			coordinator.initiate(new UserRequest(new FileInputConfig(inputPath), new FileOutputConfig(outputPath), String.valueOf(delimiter)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
