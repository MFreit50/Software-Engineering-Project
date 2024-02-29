
public class UserRequest implements UserRequestAPI{
    private InputConfig fileInputPath;
    private OutputConfig fileOutputPath;
    private String delimiter;

    public UserRequest(InputConfig fileInputPath, OutputConfig fileOutputPath, String delimiter){
        this.fileInputPath = fileInputPath;
        this.fileOutputPath = fileOutputPath;
        this.delimiter = delimiter;
    }

    //Accessor methods
    public InputConfig getInputConfig(){
        return fileInputPath;
    }
    public OutputConfig getOutputConfig(){
        return fileOutputPath;
    }
    public InputConfig getFileInputPath(){
        return fileInputPath.getFileName();
    }
    public OutputConfig getFileOutputPath(){
        return fileOutputPath.getFileName();
    }
    public String getDelimiter(){
        return delimiter;
    }

    public JobStatus.JobStatusCheck checkJobStatus() {
        return JobStatus.JobStatusCheck.FAILURE; // Default failure status
    }
}