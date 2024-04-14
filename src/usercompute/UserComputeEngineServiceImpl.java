package usercompute;

import io.grpc.stub.StreamObserver;

import java.util.List;


public class UserComputeEngineServiceImpl  extends UserComputeEngineServiceGrpc.UserComputeEngineServiceImplBase {

    private final ComputeEngine computeEngine;

    public UserComputeEngineServiceImpl() {
        this.computeEngine = new ComputeEngine();
    }

    public void findFactors(UserComputeEngine.FindFactorsRequest request,
                            StreamObserver<UserComputeEngine.FindFactorsResponse> responseObserver) {
        UserComputeEngine.FindFactorsResponse response;
        try {
            int[] nums = request.getNumsList().stream().mapToInt(Integer::intValue).toArray();
            List<String> factors = computeEngine.findFactors(nums);
            response = UserComputeEngine.FindFactorsResponse.newBuilder()
                    .addAllFactors(factors)
                    .build();
        } catch (Exception e) {
            response = UserComputeEngine.FindFactorsResponse.newBuilder()
                    .setErrorMessage(e.getMessage())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
