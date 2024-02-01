public interface Data_Engine_API {
    // Method for reading data from the input source
    void readData(InputSource inputSource);

    // Method for writing data to the output destination
    void writeData(OutputDestination outputDestination, String data);

}
//Prototype
public void testDataEngineAPI(Data_Engine_API engine) {
    // Read data from the input source
    engine.readData(InputSource.LOCAL_FILE);

    // Write data to the output destination
    engine.writeData(OutputDestination.DATABASE, "Processed data");
}

