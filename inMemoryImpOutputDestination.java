import java.util.ArrayList;
import java.util.List;

public class inMemoryImpOutputDestination implements OutputDestination{
    private List <String> data = new ArrayList<>();
    public List<String> writeData() {
        return data;
    }
}

