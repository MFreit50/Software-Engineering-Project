import dataengine.DataEngineAPI;
import dataengine.DataResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryImpDataEngineAPI implements DataEngineAPI {
    private String inputSource;
    private String outputDestination;
    private List<String> inputData;
    private DataResult readStatus;
    private DataResult writeStatus;

    public InMemoryImpDataEngineAPI() {
        this.inputData = new ArrayList<>();
        this.readStatus = new DataResult(null, EngineStatus.NO_ERROR);
        this.writeStatus = new DataResult(null, EngineStatus.NO_ERROR);
    }

    @Override
    public DataResult readData(String inputSource) {
        this.inputSource = inputSource;
        return readStatus;
    }

    @Override
    public DataResult writeData(String outputDestination, List<String> data) throws IOException {
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

    public int[] getNumbers() {
        int[] numbers = new int[0];
        return numbers;
    }
}
