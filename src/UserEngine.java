
public class UserEngine implements UserEngineAPI{
    private String inputSource;
    private String outputDestination;
    private Character delimiter;

    //Mutator methods
    public void setInputSource(String inputSource){
        this.inputSource = inputSource;
    }
    public void setOutputDestination(String outputDestination){
        this.outputDestination = outputDestination;
    }
    public void setDelimiter(Character delimiter) {
        this.delimiter = delimiter;
    }
    public void setDefaultDelimiter() {
        this.delimiter = ';';
    }

    //Accessor methods
    public String getInputSource(){
        return inputSource;
    }
    public String getOutputDestination(){
        return outputDestination;
    }
    public Character getDelimiter(){
        return delimiter;
    }

    public JobStatus.JobStatusCheck checkJobStatus() {
        return JobStatus.JobStatusCheck.FAILURE; // Default failure status
    }
}