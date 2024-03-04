import java.util.LinkedList;
import java.util.List;
public class FactoringImp {
    private char delimiter;
    public List<String> findFactors(int [] nums){
        List<String> factors = new LinkedList<>();
        for(int i : nums) {
            factors.add(findFactorsHelper(i));
            factors.add(String.valueOf(delimiter));
        }
        return factors;
    }
    private String findFactorsHelper(int num) {
        StringBuilder factorString = new StringBuilder();
        factorString.append(num).append("=");
        for (int i = 1; i<=num; ++i){
            if(num % i == 0) {
                factorString.append(i).append(",");
            }
        }
        factorString.deleteCharAt(factorString.length() - 1).append(delimiter);
        return factorString.toString();
    }
    public  void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }
}

