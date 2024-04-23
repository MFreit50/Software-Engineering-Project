package dataengine;

import java.util.concurrent.TimeUnit;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import dataengine.DataEngineGrpc.DataEngineBlockingStub;
import dataengine.DataEngineService.ReadDataRequest;
import dataengine.DataEngineService.DataEngineResponse;;

public class DataEngineClient {
    //private final ManagedChannel channel;
    private final DataEngineBlockingStub blockingStub;

    public DataEngineClient(Channel channel){
        blockingStub = DataEngineGrpc.newBlockingStub(channel);
    }

    public void readData(String fileInputPath){
        ReadDataRequest request = ReadDataRequest.newBuilder().setFileInputPath(fileInputPath).build();
        DataEngineResponse response;
        try{
            response = blockingStub.readData(request);
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
            return;
        }
        if (response.hasErrorMessage()) {
	    	System.err.println("Error: " + response.getErrorMessage());
	    } else {
	    	System.out.println("Data Result: " + response.getComputedResultsList());
	    }
    }

    public static void main(String[] args) throws InterruptedException {
        String target = "localhost:50051";
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
        try {
            DataEngineClient client = new DataEngineClient(channel);
            client.readData("src/factors.txt");
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
