public interface WriteData {
	WriteDataStatus getStatus();
	
	public static enum WriteDataStatus {
		SUCCESS,
		FAILURE;
	}
}
