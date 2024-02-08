public interface DataEngineAPI {
    // Method for reading data from the input source
    void readData(InputSource inputSource);

    // Method for writing data to the output destination
    void writeData(OutputDestination outputDestination, String data);

    //checks that returned computation is valid
    void validateReturn(DataEngineAPI data);

}
