import java.util.LinkedList;
import java.util.List;
public class FactoringImp {
    public static List<String> findFactors(int [] nums){
        List<String> factors = new LinkedList<>();
        for(int i : nums) {
            factors.add(findFactorsHelper(i));
        }
        return factors;
    }
    private static String findFactorsHelper(int num) {
        StringBuilder factorString = new StringBuilder();
        factorString.append(num).append("=");
        for (int i = 1; i<=num; ++i){
            if(num % i == 0) {
                factorString.append(i).append(",");
            }
        }
        factorString.setCharAt(factorString.length() - 1, ';');
        return factorString.toString();
    }
}
