import java.util.LinkedList;
import java.util.List;
public class FactoringImp {
    private String delimiter = ";";
    public static List<String> findFactors(int [] nums){
        List<String> factors = new LinkedList<>();
        for(int i : nums) {
            String s = "";
            factors.add(findFactorsHelper(i,s));
        }
        return factors;
    }
    private static String findFactorsHelper(int num, String delimeter) {
        StringBuilder factorString = new StringBuilder();
        factorString.append(num).append("=");
        for (int i = 1; i<=num; ++i){
            if(num % i == 0) {
                factorString.append(i).append(",");
            }
        }
        factorString.append(delimeter);
        return factorString.toString();
    }
    public  void setDelimiter(String delim) {
        delimiter = delim;
    }
}
