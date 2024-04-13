package dataengine;
import java.util.List;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import dataengine.DataEngineServiceGrpc;

public class DataEngineServiceImpl extends DataEngineServiceGrpc.DataEngineServiceImplBase {

    private final DataEngine dataEngine;

    public DataEngineServiceImpl(DataEngine dataEngine) {
        this.dataEngine = dataEngine;
    }

    @Override
    public void readData(ReadDataRequest request, StreamObserver<ReadDataResponse> responseObserver) {
        String fileInputPath = request.getFileInputPath();
        DataResult result = dataEngine.readData(fileInputPath);

        ReadDataResponse.Builder responseBuilder = ReadDataResponse.newBuilder();

        if (result.getEngineStatus() == DataEngine.EngineStatus.NO_ERROR) {
            int[] computedResults = result.getComputedResults();
            if (computedResults != null) {
                for (int computedResult : computedResults) {
                    responseBuilder.addNumbers(computedResult);
                }
            }
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void writeData(WriteDataRequest request, StreamObserver<WriteDataResponse> responseObserver) {
        WriteDataResponse response;
        String fileOutputPath = request.getFileName();
        List<String> data = request.getWriteData();
        try{
            DataResult result = dataEngine.WriteData(fileOutputPath,data);
            boolean success = result.getEngineStatus() == DataEngineAPI.EngineStatus.NO_ERROR;
            response = WriteDataResponse.newBuilder()
                    .setResult(success)
                    .build();
        } catch(Exception e) {
            response = WriteDataResponse.newBuilder()
                    .setErrorMessage(e.getMessage())
                    .build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

