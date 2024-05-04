package usercompute;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserComputeEngineClient {
    private final ManagedChannel channel;
    private final UserComputeEngineServiceGrpc.UserComputeEngineServiceBlockingStub blockingStub;

    public UserComputeEngineClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = UserComputeEngineServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void findFactors(int[] numbers) {

        List<Integer> numsList = new ArrayList<>(numbers.length);
        for (int num : numbers) {
            numsList.add(num);
        }
        UserComputeEngine.FindFactorsRequest request = UserComputeEngine.FindFactorsRequest.newBuilder()
                .addAllNums(numsList)
                .build();

        UserComputeEngine.FindFactorsResponse response = blockingStub.findFactors(request);

        System.out.println("Factors:");
        for (String factor : response.getFactorsList()) {
            System.out.println(factor);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String host = "localhost";
        int port = 50051;

        UserComputeEngineClient client = new UserComputeEngineClient(host, port);
        try {
            int[] numbers = {10, 15, 20}; // Example numbers
            client.findFactors(numbers);
        } finally {
            client.shutdown();
        }
    }
}

