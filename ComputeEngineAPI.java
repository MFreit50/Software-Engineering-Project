public interface ComputeEngineAPI{
	// Initialize process
	void initialize();

	// Read data from the input source
	void readData(InputSource inputSource);

    // Write data to the output destination
    void writeData(OutputDestination outputDestination, String data);

	// Perform computation
	void computeProcess();
}