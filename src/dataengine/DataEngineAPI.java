package dataengine;
import java.io.IOException;
import java.util.List;
public interface DataEngineAPI {
    public enum EngineStatus{
        FILE_NOT_FOUND(true),
        FILE_READ_ERROR(true),
        FILE_WRITE_ERROR(true),
        INVALID_PATH(true),
        INVALID_INPUT_DELIMITER(true),
        INVALID_INTEGER_FORMAT(true),
        NO_ERROR(false);

        private final boolean status;
        EngineStatus(boolean status){
            this.status = status;
        }
        public boolean status(){
            return status;
        }
    }
    // Method for reading data from the input source
    public DataResult readData(String inputSource);

    // Method for writing data to the output destination
    public DataResult writeData(String outputDestination, List<String> data)throws IOException;

    //mutator methods
    public void setInputSource(String inputSource);
    public void setOutputDestination(String outputDestination);
}