package dataengine;
public class  DataResult{
    private int[] computedResults;
    private DataEngineAPI.EngineStatus engineStatus;

    public DataResult(int[] computedResults, DataEngineAPI.EngineStatus engineStatus){
        this.computedResults = computedResults;
        this.engineStatus = engineStatus;
    }

    public static int[] getComputedResults() {
        return computedResults;
    }

    public DataEngineAPI.EngineStatus getEngineStatus() {
        return engineStatus;
    }
}