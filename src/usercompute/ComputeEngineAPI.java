package usercompute;
import java.util.List;

public interface ComputeEngineAPI{
	// Perform computation
	public List<String> findFactors(List<Integer> numbersToFactor);
	String findFactorsHelper(int num);
	void setDelimiter(char delimiter);
}
