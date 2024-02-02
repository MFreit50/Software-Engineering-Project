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

    public void testComputeEngineAPI(ComputeEngineAPI engine){
        engine.initialize(key);

        engine.readData(InputSource inputSource);

        engine.sendData(OutputSource outputSource);
    }

    public void testCoordinatorAPI(testCoordinatorAPI engine){
        engine.sendRequest(data);
        engine.retrieveRequest(data);

        //send and receive requests from ComputeEngineAPI
        engine.sendRequest(data);
        engine.retrieveRequest(data);

        //send and receive requests from DataEngineAPI
        engine.sendRequest(data);
        engine.retrieveRequest(data);
    }

}
//Prototype
