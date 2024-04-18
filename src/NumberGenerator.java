import java.util.LinkedList;
import java.util.List;
import dataengine.DataEngineServiceImpl;

//Used for generating 
public class NumberGenerator {
    public void generateNumbers(int amountOfNumbers, int rangeMin, int rangeMax){
        List<String> generatedNumbers = new LinkedList<>();
        while(amountOfNumbers-- > 0){
            generatedNumbers.add(String.valueOf( (int) (Math.random() * (rangeMax - rangeMin + 1) + rangeMin) + ","));
        }
        DataEngineServiceImpl dataEngine = new DataEngineServiceImpl(); 
        dataEngine.writeData("src/factors.txt", generatedNumbers);
    }
}
