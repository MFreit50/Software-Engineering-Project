public interface User_Engine_API {
    // Method to set the input source
    void setInputSource(InputSource inputSource);

    // Method to set the output destination
    void setOutputDestination(OutputDestination outputDestination);

    // Method to set the delimiter characters for output
    void setDelimiter(Character delimiter);

    // Method to set default delimiters
    void setDefaultDelimiters();

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
