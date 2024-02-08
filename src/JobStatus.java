public interface JobStatus {
	JobStatus getStatus();
	
	public static enum JobStatusCheck {
		SUCCESS,
		FAILURE;
	}
}