public interface UserEngineAPI{
    // Method to set the input source
    void setInputSource(String inputSource);

    // Method to set the output destination
    void setOutputDestination(String outputDestination);

    // Method to set the delimiter characters for output
    void setDelimiter(Character delimiter);

    // Method to set default delimiters
    void setDefaultDelimiter();

    // Method to generate a key 
    String generateKey();

    // Method to kick off the job and return success/failure status
    JobStatus.JobStatusCheck checkJobStatus();
}
