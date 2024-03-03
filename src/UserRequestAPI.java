
public interface UserRequestAPI{
    //Accessor methods

    InputConfig getInputConfig();
    OutputConfig getOutputConfig();
    String getFileInputPath();
    String getFileOutputPath();
    String getDelimiter();
    
    JobStatus.JobStatusCheck checkJobStatus();
}