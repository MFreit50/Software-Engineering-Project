import java.util.ArrayList;
import java.util.List;

public class InMemoryImpInputConfig implements InputConfig {
    private List<Integer> inputData = new ArrayList<>();
    public InMemoryImpInputConfig(List<Integer> inputData) {

    }
    @Override
    public List<Integer> getInputData() {
        return this.inputData;
    }
    @Override
    public String getInputSource() {
        return null;
    }
    @Override
    public void setInputSource(String inputSource) {

    }
}