import java.util.ArrayList;
import java.util.List;

public class InMemoryImpOutputConfig implements OutputConfig {
    private final List<String> outputData = new ArrayList<>();
    @Override
    public void writeOutput(List<String> outputData) {

    }
    @Override
    public String getOutputSource() {
        return null;
    }
    @Override
    public void setOutputSource(String outputSource) {

    }
    public String getFileName(){
        return null;
    }
}
