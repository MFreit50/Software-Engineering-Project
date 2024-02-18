public interface UserEngineAPI{
    //Mutator methods
    void setInputSource(String inputSource);
    void setOutputDestination(String outputDestination);
    void setDelimiter(Character delimiter);
    void setDefaultDelimiter();

    //Accessor methods
    String getInputSource();
    String getOutputDestination();
    Character getDelimiter();
    
    // Method to kick off the job and return success/failure status
    JobStatus.JobStatusCheck checkJobStatus();
}
