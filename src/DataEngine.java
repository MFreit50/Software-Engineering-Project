import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class DataEngine implements DataEngineAPI{
    public String fileInputPath;
    public String fileOutputPath;
    public int[] computedResults = null;

    public DataResult readData(String fileInputPath){
        try(Scanner fileScanner = new Scanner(fileInputPath)){
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
            if(e instanceof FileNotFoundException){
                return new DataResult(null, EngineStatus.FILE_NOT_FOUND);
            }else if(e instanceof NumberFormatException){
                return new DataResult(null, EngineStatus.INVALID_INTEGER_FORMAT);
            }else{
                e.printStackTrace();
                return new DataResult(null, EngineStatus.FILE_READ_ERROR);
            }
        }
        return new DataResult(computedResults, EngineStatus.NO_ERROR);
    }

    public DataResult writeData(String fileOutputPath, List<String> data)throws IOException{
        try{
            File outputFile = new File(fileOutputPath);

            //create the output file if it does not exist
            if(outputFile.exists() == false){
                outputFile.mkdirs();
            }
            
            FileWriter fileWriter = new FileWriter(outputFile);
            for(String datum : data){
                fileWriter.write(datum);
            }
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
            return new DataResult(null, EngineStatus.FILE_WRITE_ERROR);
        }
        return new DataResult(null, EngineStatus.NO_ERROR);
    }

    public void setInputSource(String fileInputPath){
        this.fileInputPath = fileInputPath;
    }
    public void setOutputDestination(String fileOutputPath){
        this.fileOutputPath = fileOutputPath;
    }
}