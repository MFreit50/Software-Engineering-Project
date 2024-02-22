import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryImpDataEngineAPI implements DataEngineAPI {
    private String inputSource;
    private String outputDestination;
    private List<String> inputData;
    private EngineStatus readStatus;
    private EngineStatus writeStatus;

    public InMemoryImpDataEngineAPI() {
        this.inputData = new ArrayList<>();
        this.readStatus = EngineStatus.NO_ERROR;
        this.writeStatus = EngineStatus.NO_ERROR;
    }

    @Override
    public EngineStatus readData(String inputSource) {
        this.inputSource = inputSource;
        return readStatus;
    }

    @Override
    public EngineStatus writeData(String outputDestination, List<String> data) throws IOException {
        this.outputDestination = outputDestination;
        this.inputData.addAll(data);
        return writeStatus;
    }

    @Override
    public void setInputSource(String inputSource) {
        this.inputSource = inputSource;
    }

    @Override
    public void setOutputDestination(String outputDestination) {
        this.outputDestination = outputDestination;
    }

    @Override
    public int[] getNumbers() {
        int[] numbers = new int[0];
        return numbers;
    }
}
