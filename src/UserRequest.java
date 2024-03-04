
public class UserRequest implements UserRequestAPI{
    private InputConfig fileInputPath;
    private OutputConfig fileOutputPath;
    private char delimiter;

    public UserRequest(InputConfig fileInputPath, OutputConfig fileOutputPath, char delimiter){
        this.fileInputPath = fileInputPath;
        this.fileOutputPath = fileOutputPath;
        this.delimiter = delimiter;
    }
    public UserRequest(InputConfig fileInputPath, OutputConfig fileOutputPath){
        this.fileInputPath = fileInputPath;
        this.fileOutputPath = fileOutputPath;
        delimiter = ';';
    }
    //Mutator methods
    public void setDelimiter(char delimiter){
        this.delimiter = delimiter;
    }
    //Accessor methods
    public InputConfig getInputConfig(){
        return fileInputPath;
    }
    public OutputConfig getOutputConfig(){
        return fileOutputPath;
    }
    public String getFileInputPath(){
        return fileInputPath.getFileName();
    }
    public String getFileOutputPath(){
        return fileOutputPath.getFileName();
    }
    public char getDelimiter(){
        return delimiter;
    }

    public JobStatus.JobStatusCheck checkJobStatus() {
        return JobStatus.JobStatusCheck.FAILURE; // Default failure status
    }
}