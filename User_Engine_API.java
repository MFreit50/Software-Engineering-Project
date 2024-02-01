public interface User_Engine_API{
    // Method to set the input source
    void setInputSource(InputSource inputSource);

    // Method to set the output destination
    void setOutputDestination(OutputDestination outputDestination);

    // Method to set the delimiter characters for output
    void setDelimiter(Character delimiter);

    // Method to set default delimiters
    void setDefaultDelimiters();
}

