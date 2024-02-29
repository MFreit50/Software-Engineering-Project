
public interface UserRequestAPI{
    //Accessor methods
    InputConfig getFileInputPath();
    OutputConfig getFileOutputPath();
    String getDelimiter();

    JobStatus.JobStatusCheck checkJobStatus();
}