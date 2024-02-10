import java.util.ArrayList;
import java.util.List;

public class InMemoryImpOutputDestination implements OutputDestination{
    private List <String> data = new ArrayList<>();
    public List<String> writeData() {
        return data;
    }
}

