import src.DataEngineAPI;
import src.OutputDestination;
public class InMemoryImpDataEngineAPI implements DataEngineAPI{
    public void readData(E e){
        InputSource.readData(e);
    }
    public void writeData(E e){
        OutputDestination.writeData(e);
    }
}