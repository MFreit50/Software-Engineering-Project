package dataengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import java.io.IOException;

import dataengine.DataEngineService.EngineStatus;
import dataengine.DataEngineService.DataEngineResponse;
import dataengine.DataEngineService.ReadDataRequest;
import dataengine.DataEngineService.WriteDataRequest;
import io.grpc.stub.StreamObserver;


import dataengine.DataEngineGrpc.DataEngineImplBase;

public class DataEngineServiceImpl extends DataEngineImplBase {

    @Override
    public void readData(ReadDataRequest request, StreamObserver<DataEngineResponse> responseObserver){
        DataEngineResponse response = readData(request.getFileInputPath());

        // gRPC magic for RPC return values across the network
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void writeData(WriteDataRequest request, StreamObserver<DataEngineResponse> responseObserver) {
        DataEngineResponse response = writeData(request.getFileOutputPath(), request.getDataList());

        // gRPC magic for RPC return values across the network
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public DataEngineResponse readData(String fileInputPath){
        List<Integer> computedResults;
        try(Scanner fileScanner = new Scanner(new File(fileInputPath))){
            //list stores data in the file
            LinkedList<Integer> list = new LinkedList<>();
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] inputNumbers = line.split(",");
                for(String i : inputNumbers){
                    //trim any white space from input, parse to Int and add to list
                    list.add(Integer.parseInt(i.trim()));
                }
            }
            computedResults = list.stream().map(Integer::intValue).collect(Collectors.toList());
            list.clear();
        }catch(Exception e){
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                return buildDataEngineResponse(null, EngineStatus.FILE_NOT_FOUND, e);
            }else if(e instanceof NumberFormatException){
                return buildDataEngineResponse(null, EngineStatus.INVALID_INTEGER_FORMAT, e);
            }else{
                return buildDataEngineResponse(null, EngineStatus.FILE_READ_ERROR, e);
            }
        }
        return buildDataEngineResponse(computedResults, EngineStatus.NO_ERROR);
    }

    public DataEngineResponse writeData(String fileOutputPath, List<String> data){
        try{
            File outputFile = new File(fileOutputPath);

            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            
            FileWriter fileWriter = new FileWriter(outputFile);
            for(String datum : data){
                fileWriter.write(datum);
            }
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
            return buildDataEngineResponse(null, EngineStatus.FILE_WRITE_ERROR, e);
        }
        return buildDataEngineResponse(null, EngineStatus.NO_ERROR);
    }

    public DataEngineResponse buildDataEngineResponse(Iterable<? extends Integer> computedResults, EngineStatus engineStatus, Exception e){
        return DataEngineResponse.newBuilder()
                .addAllComputedResults(computedResults)
                .setEngineStatus(EngineStatus.INVALID_INTEGER_FORMAT)
                .setSuccess(engineStatus == EngineStatus.NO_ERROR)
                .setErrorMessage(e.getMessage()).build();
    }
    public DataEngineResponse buildDataEngineResponse(Iterable<? extends Integer> computedResults, EngineStatus engineStatus){
        return DataEngineResponse.newBuilder()
                .addAllComputedResults(computedResults)
                .setEngineStatus(EngineStatus.INVALID_INTEGER_FORMAT)
                .setSuccess(engineStatus == EngineStatus.NO_ERROR).build();
    }

}