
public interface UserRequestAPI{
    //Mutator methods
    void setDelimiter(char delimiter);

    //Accessor methods
    InputConfig getInputConfig();
    OutputConfig getOutputConfig();
    String getFileInputPath();
    String getFileOutputPath();
    char getDelimiter();
    
    JobStatus.JobStatusCheck checkJobStatus();
}