package usercompute;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.1)",
    comments = "Source: UserComputeEngine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserComputeEngineServiceGrpc {

  private UserComputeEngineServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "usercompute.UserComputeEngineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<usercompute.UserComputeEngine.FindFactorsRequest,
      usercompute.UserComputeEngine.FindFactorsResponse> getFindFactorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindFactors",
      requestType = usercompute.UserComputeEngine.FindFactorsRequest.class,
      responseType = usercompute.UserComputeEngine.FindFactorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<usercompute.UserComputeEngine.FindFactorsRequest,
      usercompute.UserComputeEngine.FindFactorsResponse> getFindFactorsMethod() {
    io.grpc.MethodDescriptor<usercompute.UserComputeEngine.FindFactorsRequest, usercompute.UserComputeEngine.FindFactorsResponse> getFindFactorsMethod;
    if ((getFindFactorsMethod = UserComputeEngineServiceGrpc.getFindFactorsMethod) == null) {
      synchronized (UserComputeEngineServiceGrpc.class) {
        if ((getFindFactorsMethod = UserComputeEngineServiceGrpc.getFindFactorsMethod) == null) {
          UserComputeEngineServiceGrpc.getFindFactorsMethod = getFindFactorsMethod =
              io.grpc.MethodDescriptor.<usercompute.UserComputeEngine.FindFactorsRequest, usercompute.UserComputeEngine.FindFactorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindFactors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  usercompute.UserComputeEngine.FindFactorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  usercompute.UserComputeEngine.FindFactorsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserComputeEngineServiceMethodDescriptorSupplier("FindFactors"))
              .build();
        }
      }
    }
    return getFindFactorsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserComputeEngineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserComputeEngineServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserComputeEngineServiceStub>() {
        @java.lang.Override
        public UserComputeEngineServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserComputeEngineServiceStub(channel, callOptions);
        }
      };
    return UserComputeEngineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserComputeEngineServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserComputeEngineServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserComputeEngineServiceBlockingStub>() {
        @java.lang.Override
        public UserComputeEngineServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserComputeEngineServiceBlockingStub(channel, callOptions);
        }
      };
    return UserComputeEngineServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserComputeEngineServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserComputeEngineServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserComputeEngineServiceFutureStub>() {
        @java.lang.Override
        public UserComputeEngineServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserComputeEngineServiceFutureStub(channel, callOptions);
        }
      };
    return UserComputeEngineServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void findFactors(usercompute.UserComputeEngine.FindFactorsRequest request,
        io.grpc.stub.StreamObserver<usercompute.UserComputeEngine.FindFactorsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindFactorsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserComputeEngineService.
   */
  public static abstract class UserComputeEngineServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UserComputeEngineServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserComputeEngineService.
   */
  public static final class UserComputeEngineServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserComputeEngineServiceStub> {
    private UserComputeEngineServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserComputeEngineServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserComputeEngineServiceStub(channel, callOptions);
    }

    /**
     */
    public void findFactors(usercompute.UserComputeEngine.FindFactorsRequest request,
        io.grpc.stub.StreamObserver<usercompute.UserComputeEngine.FindFactorsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindFactorsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserComputeEngineService.
   */
  public static final class UserComputeEngineServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserComputeEngineServiceBlockingStub> {
    private UserComputeEngineServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserComputeEngineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserComputeEngineServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public usercompute.UserComputeEngine.FindFactorsResponse findFactors(usercompute.UserComputeEngine.FindFactorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindFactorsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserComputeEngineService.
   */
  public static final class UserComputeEngineServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserComputeEngineServiceFutureStub> {
    private UserComputeEngineServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserComputeEngineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserComputeEngineServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<usercompute.UserComputeEngine.FindFactorsResponse> findFactors(
        usercompute.UserComputeEngine.FindFactorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindFactorsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_FACTORS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_FACTORS:
          serviceImpl.findFactors((usercompute.UserComputeEngine.FindFactorsRequest) request,
              (io.grpc.stub.StreamObserver<usercompute.UserComputeEngine.FindFactorsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFindFactorsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              usercompute.UserComputeEngine.FindFactorsRequest,
              usercompute.UserComputeEngine.FindFactorsResponse>(
                service, METHODID_FIND_FACTORS)))
        .build();
  }

  private static abstract class UserComputeEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserComputeEngineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return usercompute.UserComputeEngine.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserComputeEngineService");
    }
  }

  private static final class UserComputeEngineServiceFileDescriptorSupplier
      extends UserComputeEngineServiceBaseDescriptorSupplier {
    UserComputeEngineServiceFileDescriptorSupplier() {}
  }

  private static final class UserComputeEngineServiceMethodDescriptorSupplier
      extends UserComputeEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserComputeEngineServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserComputeEngineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserComputeEngineServiceFileDescriptorSupplier())
              .addMethod(getFindFactorsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
