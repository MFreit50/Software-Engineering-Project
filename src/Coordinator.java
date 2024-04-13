import usercompute.ComputeEngine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Coordinator {
    public void initiateMultiThreaded(List<UserRequest> requests) {
        int numThreads = 4; // Upper bound set to 4 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(numThreads);
        List<Future<?>> results = new ArrayList<>();

        for (UserRequest request : requests) {
            results.add(threadPool.submit(() -> {
                try {
                    initiate(request);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        // Wait for all tasks to complete
        for (Future<?> result : results) {
            try {
                result.get();
            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
            }
        }

        // Shut down the thread pool
        threadPool.shutdown();
    }

    public DataResult initiate(UserRequest request) throws IOException{
        DataEngine dataEngine = new DataEngine();
        ComputeEngine computeEngine = new ComputeEngine();
        DataResult dataResult;
        try {
            dataResult = dataEngine.readData(request.getFileInputPath());
            if (dataResult.getEngineStatus() != DataEngine.EngineStatus.NO_ERROR) {
                return dataResult;
            }
            computeEngine.setDelimiter(request.getDelimiter());//set delimiter for ComputeEngine
            dataEngine.writeData(request.getFileOutputPath(), computeEngine.findFactors(dataResult.getComputedResults()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataResult;
    }
}