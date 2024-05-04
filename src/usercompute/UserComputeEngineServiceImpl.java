package usercompute;

import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.stream.Collectors;


public class UserComputeEngineServiceImpl  extends UserComputeEngineServiceGrpc.UserComputeEngineServiceImplBase {

    private final ComputeEngine computeEngine;

    public UserComputeEngineServiceImpl() {
        this.computeEngine = new ComputeEngine();
    }

    public void findFactors(UserComputeEngine.FindFactorsRequest request,
                            StreamObserver<UserComputeEngine.FindFactorsResponse> responseObserver) {
        UserComputeEngine.FindFactorsResponse response;
        try {
            List<Integer> nums = request.getNumsList().stream().map(Integer::intValue).collect(Collectors.toList());
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
