import java.io.IOException;
import java.util.Scanner;

import dataengine.DataEngineService.DataEngineResponse;

public class UserInterface{
    public static void main(String[] args) throws IOException{
        inititate();
    }
    public static void inititate() throws IOException{
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert file path");
        FileInputConfig fileInputPath = new FileInputConfig(sc.nextLine());

        System.out.println("Insert output path");
        FileOutputConfig fileOutputPath = new FileOutputConfig(sc.nextLine());

        UserRequest userRequest = new UserRequest(fileInputPath, fileOutputPath);
        Coordinator coordinator = new Coordinator();

        DataEngineResponse dataResult = coordinator.initiate(userRequest);
        System.out.println(dataResult.getEngineStatus());

        sc.close();
    }
}
