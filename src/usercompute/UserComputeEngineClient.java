package usercompute;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import usercompute.UserComputeEngineGrpc;
import usercompute.FindFactorsRequest;
import usercompute.FindFactorsResponse;

public class UserComputeEngineClient {
    private final ManagedChannel channel;
    private final UserComputeEngineGrpc.ComputeEngineBlockingStub blockingStub;

    public UserComputeEngineClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = ComputeEngineGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void findFactors(int[] numbers) {
        // Create request
        FindFactorsRequest request = FindFactorsRequest.newBuilder()
                .addAllNumbers(numbers)
                .build();

        FindFactorsResponse response = blockingStub.findFactors(request);

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

