package dataengine;

import java.util.List;

import dataengine.DataEngineServiceOuterClass;
import dataengine.DataEngineServiceOuterClass.ReadDataRequest;
import dataengine.DataEngineServiceOuterClass.ReadDataResponse;
import dataengine.DataEngineServiceOuterClass.WriteDataRequest;
import dataengine.DataEngineServiceOuterClass.WriteDataResponse;
import io.grpc.stub.StreamObserver;
import java.io.IOException;


import dataengine.DataEngineServiceGrpc.DataEngineServiceImplBase;

public class DataEngineServiceImpl extends DataEngineServiceImplBase {

    private final DataEngine dataEngine;

    public DataEngineServiceImpl(DataEngine dataEngine) {
        this.dataEngine = dataEngine;
    }

    @Override
    public void readData(ReadDataRequest request, StreamObserver<ReadDataResponse> responseObserver) {
        ReadDataResponse response;
        try{
            DataResult result = dataEngine.readData(request.getFileInputPath());
            response = ReadDataResponse.newBuilder().setDataResult(result).build();
        }catch(Exception e){
            response = ReadDataResponse.newBuilder().setErrorMessage(e.getMessage()).build();
        }
        // gRPC magic for RPC return values across the network
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void writeData(WriteDataRequest request, StreamObserver<WriteDataResponse> responseObserver) {
        WriteDataResponse response;
        try{
            DataResult result = dataEngine.writeData(request.getFileOutputPath(), request.getDataList());
        }catch(Exception e){
            response = WriteDataResponse.newBuilder().setErrorMessage(e.getMessage()).build();
        }
        // gRPC magic for RPC return values across the network
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}