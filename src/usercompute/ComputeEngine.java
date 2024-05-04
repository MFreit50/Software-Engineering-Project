package usercompute;
import java.util.LinkedList;
import java.util.List;
public class ComputeEngine implements ComputeEngineAPI{
    private char delimiter;
    public List<String> findFactors(List<Integer> numbersToFactor){
        List<String> factors = new LinkedList<>();
        for(int i : numbersToFactor) {
            factors.add(findFactorsHelper(i));
        }
        return factors;
    }
    public String findFactorsHelper(int num) {
        //program will crash without this check
        if(num < 2){
            return String.valueOf(num)+"\n";
        }
        int numberSquared = (int)(Math.sqrt(num));
        StringBuilder factorFirstHalf = new StringBuilder();
        StringBuilder factorSecondHalf = new StringBuilder();
        for(int i = 1; i <= numberSquared; ++i){
            if(num % i == 0){
                factorFirstHalf.append(i).append(String.valueOf(delimiter));
                if(i != num/i){ //prevents a perfect square from being written as a factor twice
                    factorSecondHalf.insert(0, String.valueOf(delimiter)).insert(0, num / i);
                }
            }
        }
                //combine first and second half                 //remove delimiter after last value
        return factorFirstHalf.append(factorSecondHalf.deleteCharAt(factorSecondHalf.length() - 1))
        //add a new line to distinguish between current and next factor in output file
        .append("\n").toString();
    }
    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }
}