public class ComputeEngineIntegrationTest{
   public ComputeEngine computeEngine = new ComputeEngine();
   public TestDataEngineAPI dataEngine = new TestDataEngineAPI();
   public UserEngine userEngine = new UserEngine();
   
   //test input
   public int[] input = {1,10,25};
   @Test
   public initiate(UserEngine userEngine, TestDataEngineAPI dataEngine){
      userEngine.setInputSource(input);
      dataEngine.readData(input);
      dataEngine.writeData();
      userEngine.checkJobStatus();
   }
}