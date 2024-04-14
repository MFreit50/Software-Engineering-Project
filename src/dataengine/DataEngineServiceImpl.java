package dataengine;

import java.util.Arrays;
import java.util.List;

import dataengine.DataEngineService;
import dataengine.DataResultService.DataResult;
import dataengine.DataEngineService.ReadDataRequest;
import dataengine.DataEngineService.ReadDataResponse;
import dataengine.DataEngineService.WriteDataRequest;
import dataengine.DataEngineService.WriteDataResponse;
import io.grpc.stub.StreamObserver;
import java.io.IOException;


import dataengine.DataEngineGrpc.DataEngineImplBase;

public class DataEngineServiceImpl extends DataEngineImplBase {

    @Override
    public void readData(ReadDataRequest request, StreamObserver<ReadDataResponse> responseObserver) {
        final DataEngine dataEngine;
        ReadDataResponse response;
        try{
            dataengine.DataResult result =  dataEngine.readData(request.getFileInputPath());
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
        final DataEngine dataEngine;
        WriteDataResponse response;
        try{
            dataengine.DataResult result = dataEngine.writeData(request.getFileOutputPath(), request.getDataList());
            response = WriteDataResponse.newBuilder().setDataResult(result).build();
        }catch(Exception e){
            response = WriteDataResponse.newBuilder().setErrorMessage(e.getMessage()).build();
        }
        // gRPC magic for RPC return values across the network
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}