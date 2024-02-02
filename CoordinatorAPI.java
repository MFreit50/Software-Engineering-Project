public interface CoordinatorAPI{

	//send and receive requests from UserEngineAPI
	void sendRequest(UserEngineAPI data);
	void retrieveRequest(UserEngineAPI data);

	//send and receive requests from ComputeEngineAPI
	void sendRequest(ComputeEngineAPI data);
	void retrieveRequest(ComputeEngineAPI data);

	//send and receive requests from DataEngineAPI
	void sendRequest(DataEngineAPI data);
	void retrieveRequest(DataEngineAPI data);
}