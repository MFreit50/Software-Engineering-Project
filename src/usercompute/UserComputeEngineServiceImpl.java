package usercompute;

import java.util.LinkedList;
import java.util.List;
import usercompute.UserComputeEngineServiceGrpc.UserComputeEngineServiceImplBase;
import io.grpc.stub.StreamObserver;


public class UserComputeEngineServiceImpl  extends UserComputeEngineServiceGrpc.UserComputeEngineServiceImplBase {

    private final ComputeEngine computeEngine;

    public UserComputeEngineServiceImpl() {
        this.computeEngine = new ComputeEngine();
    }

    public void findFactors(FindFactorsRequest request,
                            StreamObserver<FindFactorsResponse> responseObserver) {
        FindFactorResponse response;
        try {
            int[] nums = request.getNumsList().stream().mapToInt(Integer::intValue).toArray();
            List<String> factors = computeEngine.findFactors(nums);
            response = FindFactorsResponse.newBuilder()
                    .addAllFactors(factors)
                    .build();
        } catch (Exception e) {
            response = FindFactorsResponse.newBuilder()
                    .setErrorMessage(e.getMessage())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
