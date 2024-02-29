public class Coordinator{
    DataEngine dataEngine;
    FactoringImp compute;


    Coordinator(DataEngine dataEngine, FactoringImp compute){
        this.dataEngine = dataEngine;
        this.compute = compute;
    }
    public void initiate(UserRequest request){
        //if DataEngine Encountrs Error return
        if(dataEngine.readData(request.getFileInputPath()).status){
            return;
        }
        dataEngine.writeData(request.getFileOutputPath(), compute.findFactors(dataEngine.getNumbers()));
    }
}