public class DataEngine implements DataEngineAPI{
    public void readData(InputSource inputSource){
        
    }

    public WriteData.WriteDataStatus writeData(OutputDestination outputDestination, String data){
        return WriteData.WriteDataStatus.FAILURE; // Default failure status
    }
	
}