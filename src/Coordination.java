public class Coordination {
    public void initiate(){
        DataEngine.readData(UserEngine.getInputSource());
        DataEngine.writeData(UserEngine.getOutputDestination(), FactoringImp.findFactors(DataEngine.getNumbers()));
    }
}
