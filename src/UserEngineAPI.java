public interface UserEngineAPI{
    //Mutator methods
    void setInputSource(String inputSource);
    void setOutputDestination(String outputDestination);
    void setDelimiter(String delimiter);
    void setDefaultDelimiter();

    //Accessor methods
    String getInputSource();
    String getOutputDestination();
    String getDelimiter();
    
    // Method to kick off the job and return success/failure status
    JobStatus.JobStatusCheck checkJobStatus();
}
