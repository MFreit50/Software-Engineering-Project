import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

import usercompute.ComputeEngine;
import dataengine.DataEngineService.DataEngineResponse;
import dataengine.DataEngineService.EngineStatus;
import dataengine.DataEngineServiceImpl;

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

    public DataEngineResponse initiate(UserRequest request) throws IOException{
        DataEngineServiceImpl dataEngine = new DataEngineServiceImpl();
        ComputeEngine computeEngine = new ComputeEngine();
        DataEngineResponse dataResult;

        dataResult = dataEngine.readData(request.getFileInputPath());
        if (dataResult.getEngineStatus() != EngineStatus.NO_ERROR) {
            return dataResult;
        }
        computeEngine.setDelimiter(request.getDelimiter());//set delimiter for ComputeEngine
        dataEngine.writeData(request.getFileOutputPath(), computeEngine.findFactors(dataResult.getComputedResultsList()));
        
        return dataResult;
    }
}