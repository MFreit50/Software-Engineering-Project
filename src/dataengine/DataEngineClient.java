package dataengine;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import dataengine.DataEngineServiceGrpc;

public class DataEngineClient {
    private final ManagedChannel channel;
    private final DataEngineServiceGrpc.DataEngineBlockingStub blockingStub;

    public DataEngineClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = DataEngineServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void readData(String fileInputPath) {
        ReadDataRequest request = ReadDataRequest.newBuilder()
                .setFileInputPath(fileInputPath)
                .build();
        try {
            ReadDataResponse response = blockingStub.readData(request);
            System.out.println("Data received from server:");
            for (int number : response.getNumbersList()) {
                System.out.println(number);
            }
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DataEngineClient client = new DataEngineClient("localhost", 50051);
        try {
            client.readData("example.txt");
        } finally {
            client.shutdown();
        }
    }
}
