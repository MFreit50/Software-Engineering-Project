import java.util.List;

public class FileInputConfig implements InputConfig{

    private final String filePath;

    public FileInputConfig(String filePath) {
        this.filePath = filePath;
    }
    
    public String getFileName() {
        return filePath;
    }
    @Override
    public List<Integer> getInputData() {
        return null;
    }

    @Override
    public String getInputSource() {
        return null;
    }

    @Override
    public void setInputSource(String inputSource) {

    }
}
