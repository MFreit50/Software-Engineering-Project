import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

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

    public void initiate(UserRequest request) throws IOException{
        DataEngine dataEngine = new DataEngine();
        ComputeEngine computeEngine = new ComputeEngine();
        try {
            DataEngine.EngineStatus readStatus = dataEngine.readData(request.getFileInputPath());
            System.out.println(readStatus + "read status");
            if (readStatus != DataEngine.EngineStatus.NO_ERROR) {
                return;
            }
            computeEngine.setDelimiter(request.getDelimiter());//set delimiter for factoringIMP
            int[] numbers = dataEngine.getNumbers();
            dataEngine.writeData(request.getFileOutputPath(), computeEngine.findFactors(numbers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}