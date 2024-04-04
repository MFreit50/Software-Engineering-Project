import java.util.List;

public interface ComputeEngineAPI{
	// Perform computation
	public List<String> findFactors(int[] nums);
	String findFactorsHelper(int num);
	void setDelimiter(char delimiter);
}
