package dataengine;
import java.util.List;
import java.util.Scanner;

import dataengine.DataEngine;
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
            DataResult result = readData(request.getFileInputPath());
            response = ReadDataResponse.newBuilder().setDataResult(result).build();
        }catch(Exception e){
            response = ReadDataResponse.newBuilder().setErrorMessage(e.getMessage()).build();
        }
        // gRPC magic for RPC return values across the network
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    /*
    public DataResult readData(String fileInputPath){
        try(Scanner fileScanner = new Scanner(new File(fileInputPath))){
            //list stores data in the file
            LinkedList<Integer> list = new LinkedList<>();
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] inputNumbers = line.split(",");
                for(String i : inputNumbers){
                    try{
                    //trim any white space from input, parse to Int and add to list
                    list.add(Integer.parseInt(i.trim()));
                    }catch(NumberFormatException e){
                        return new DataResult(null, EngineStatus.INVALID_INTEGER_FORMAT);
                    }
                }
            }
            computedResults = list.stream().mapToInt(Integer::intValue).toArray();
            list.clear();
            fileScanner.close();
        }catch(Exception e){
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                return new DataResult(null, EngineStatus.FILE_NOT_FOUND);
            }else if(e instanceof NumberFormatException){
                return new DataResult(null, EngineStatus.INVALID_INTEGER_FORMAT);
            }else{
                return new DataResult(null, EngineStatus.FILE_READ_ERROR);
            }
        }
        return new DataResult(computedResults, EngineStatus.NO_ERROR);
    }
    */
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

