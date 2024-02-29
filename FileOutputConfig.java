import java.util.List;

public class FileOutputConfig implements OutputConfig{

    private final String filePath;

    public FileOutputConfig(String filePath) {
        this.filePath = filePath;
    }
    public String getFileName() {
        return filePath;
    }
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
}
