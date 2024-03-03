import java.util.List;

public interface OutputConfig {
    void writeOutput(List<String> outputData);
    String getOutputSource();
    void setOutputSource(String outputSource);
    String getFileName();
}
