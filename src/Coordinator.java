
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class Coordinator {
    DataEngine dataEngine;
    FactoringImp compute;

    Coordinator(DataEngine dataEngine, FactoringImp compute) {
        this.dataEngine = dataEngine;
        this.compute = compute;
    }
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

    public void initiate(UserRequest request) throws IOException {
        DataEngine.EngineStatus readStatus = dataEngine.readData(request.getFileInputPath());
        if (readStatus != DataEngine.EngineStatus.NO_ERROR) {
            return;
        }
        dataEngine.writeData(request.getFileOutputPath(), compute.findFactors(dataEngine.getNumbers()));

}