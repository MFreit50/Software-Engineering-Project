public interface ComputeEngineAPI{
	// Initialize process
	void initialize(Key key);

	// Perform computation
	private void computeProcess(Key key);

	// Read data from the input source
	void readData(InputSource inputSource);

    // Write data to the output destination
    void writeData(OutputDestination outputDestination, String data);
}