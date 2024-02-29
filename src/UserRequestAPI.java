
public interface UserRequestAPI{
    //Accessor methods
    InputConfig getInputConfig();
    OutputConfig getOutputConfig();
    InputConfig getFileInputPath();
    OutputConfig getFileOutputPath();
    String getDelimiter();

    JobStatus.JobStatusCheck checkJobStatus();
}