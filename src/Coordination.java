public class Coordination{
    public void initiate(){
        //final DataEngine.EngineStatus status = DataEngine.readData(UserEngine.getInputSource();
        //if DataEngine Encountrs Error return
        if(DataEngine.readData(UserEngine.getInputSource()).status){
            return;
        }
        DataEngine.writeData(UserEngine.getOutputDestination(), FactoringImp.findFactors(DataEngine.getNumbers()));
    }
}
