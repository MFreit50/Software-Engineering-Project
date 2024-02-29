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
    public int[] numbers = null;
    public EngineStatus readData(String fileInputPath){
        try{
            //create File object with user specified path
            File file = new File(fileInputPath);
            Scanner fileScanner = new Scanner(file);
            fileScanner.close();
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
                        return EngineStatus.INVALID_INTEGER_FORMAT;
                    }
                }
            }
            numbers = list.stream().mapToInt(Integer::intValue).toArray();
            list.clear();
        }catch(FileNotFoundException e){
            return EngineStatus.FILE_NOT_FOUND;
        }catch(Exception e){
            e.printStackTrace();
            return EngineStatus.FILE_READ_ERROR;
        }
        return EngineStatus.NO_ERROR;
    }

    public EngineStatus writeData(String fileOutputPath, List<String> data)throws IOException{
        try{
            File outputFile = new File(fileOutputPath);
            FileWriter fileWriter = new FileWriter(outputFile);
            for(String datum : data){
                fileWriter.write(datum);
            }
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
            return EngineStatus.FILE_WRITE_ERROR;
        }
        return EngineStatus.NO_ERROR;
    }

    public void setInputSource(String fileInputPath){
        this.fileInputPath = fileInputPath;
    }
    public void setOutputDestination(String fileOutputPath){
        this.fileOutputPath = fileOutputPath;
    }
    public int[] getNumbers(){
        return numbers;
    }
}