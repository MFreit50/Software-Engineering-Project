import java.util.List;
import java.util.ArrayList;
public class InMemoryImpInputSource implements InputSource {
    private List <Integer> data = new ArrayList<>();
    public List<Integer> getData() {
        return data;
    }
}
