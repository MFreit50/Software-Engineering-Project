public class Coordination{
    public void initiate(){
        //if DataEngine Encountrs Error return
        if(DataEngine.readData(UserEngine.getInputSource())){
            return;
        }
        DataEngine.writeData(UserEngine.getOutputDestination(), FactoringImp.findFactors(DataEngine.getNumbers()));
    }
}
