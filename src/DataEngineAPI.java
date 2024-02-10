public interface DataEngineAPI {
    // Method for reading data from the input source
    void readData(InputSource inputSource);

    // Method for writing data to the output destination
     WriteData.WriteDataStatus writeData(OutputDestination outputDestination, String data);

}
