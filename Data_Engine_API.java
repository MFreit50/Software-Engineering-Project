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

//Prototype
public void testUserEngineAPI(User_Engine_API engine) {
    // Set input source to a local file
    engine.setInputSource(InputSource.LOCAL_FILE);

    // Set output destination to a database
    engine.setOutputDestination(OutputDestination.DATABASE);

    // Set delimiter for output to semicolon
    engine.setDelimiter(";");

    //Set default delimiters
    engine.setDefaultDelimiters();

}