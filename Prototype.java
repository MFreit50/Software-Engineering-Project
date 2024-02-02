public class Prototype{
    public void testDataEngineAPI(DataEngineAPI engine) {
        // Read data from the input source
        engine.readData(InputSource.LOCAL_FILE);

        // Write data to the output destination
        engine.writeData(OutputDestination.DATABASE, "Processed data");
    }

    //Prototype
    public void testUserEngineAPI(UserEngineAPI engine) {
        //Set input source to a local file
        engine.setInputSource(InputSource.LOCALFILE);

        //Set output destination to a database
        engine.setOutputDestination(OutputDestination.DATABASE);

        //Set delimiter for output to semicolon
        engine.setDelimiter(";");

        //Set default delimiters
        engine.setDefaultDelimiters();
        
        //compute and get return
    }

    public void testComputeEngineAPI(ComputeEngineAPI engine) {

        engine.initialize(Key key);

        engine.readData(InputSource inputSource);

        engine.sendData(OutputSource outputSource);
    }

    public void testCoordinatorAPI(TestCoordinatorAPI engine) {
        //send and receive requests from UserEngineAPI
        engine.sendRequest(UserEngineAPI data);
        engine.retrieveRequest(UserEngineAPI data);

        //send and receive requests from ComputeEngineAPI
        engine.sendRequest(ComputeEngineAPI data);
        engine.retrieveRequest(ComputeEngineAPI data);

        //send and receive requests from DataEngineAPI
        engine.sendRequest(DataEngineAPI data);
        engine.retrieveRequest(DataEngineAPI data);
    }

}
//Prototype
