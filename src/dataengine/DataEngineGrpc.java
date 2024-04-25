package dataengine;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.1)",
    comments = "Source: DataEngineService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataEngineGrpc {

  private DataEngineGrpc() {}

  public static final java.lang.String SERVICE_NAME = "dataengine.DataEngine";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dataengine.DataEngineService.ReadDataRequest,
      dataengine.DataEngineService.DataEngineResponse> getReadDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadData",
      requestType = dataengine.DataEngineService.ReadDataRequest.class,
      responseType = dataengine.DataEngineService.DataEngineResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dataengine.DataEngineService.ReadDataRequest,
      dataengine.DataEngineService.DataEngineResponse> getReadDataMethod() {
    io.grpc.MethodDescriptor<dataengine.DataEngineService.ReadDataRequest, dataengine.DataEngineService.DataEngineResponse> getReadDataMethod;
    if ((getReadDataMethod = DataEngineGrpc.getReadDataMethod) == null) {
      synchronized (DataEngineGrpc.class) {
        if ((getReadDataMethod = DataEngineGrpc.getReadDataMethod) == null) {
          DataEngineGrpc.getReadDataMethod = getReadDataMethod =
              io.grpc.MethodDescriptor.<dataengine.DataEngineService.ReadDataRequest, dataengine.DataEngineService.DataEngineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dataengine.DataEngineService.ReadDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dataengine.DataEngineService.DataEngineResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataEngineMethodDescriptorSupplier("ReadData"))
              .build();
        }
      }
    }
    return getReadDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dataengine.DataEngineService.WriteDataRequest,
      dataengine.DataEngineService.DataEngineResponse> getWriteDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteData",
      requestType = dataengine.DataEngineService.WriteDataRequest.class,
      responseType = dataengine.DataEngineService.DataEngineResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dataengine.DataEngineService.WriteDataRequest,
      dataengine.DataEngineService.DataEngineResponse> getWriteDataMethod() {
    io.grpc.MethodDescriptor<dataengine.DataEngineService.WriteDataRequest, dataengine.DataEngineService.DataEngineResponse> getWriteDataMethod;
    if ((getWriteDataMethod = DataEngineGrpc.getWriteDataMethod) == null) {
      synchronized (DataEngineGrpc.class) {
        if ((getWriteDataMethod = DataEngineGrpc.getWriteDataMethod) == null) {
          DataEngineGrpc.getWriteDataMethod = getWriteDataMethod =
              io.grpc.MethodDescriptor.<dataengine.DataEngineService.WriteDataRequest, dataengine.DataEngineService.DataEngineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dataengine.DataEngineService.WriteDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dataengine.DataEngineService.DataEngineResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataEngineMethodDescriptorSupplier("WriteData"))
              .build();
        }
      }
    }
    return getWriteDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataEngineStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataEngineStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataEngineStub>() {
        @java.lang.Override
        public DataEngineStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataEngineStub(channel, callOptions);
        }
      };
    return DataEngineStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataEngineBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataEngineBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataEngineBlockingStub>() {
        @java.lang.Override
        public DataEngineBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataEngineBlockingStub(channel, callOptions);
        }
      };
    return DataEngineBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataEngineFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataEngineFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataEngineFutureStub>() {
        @java.lang.Override
        public DataEngineFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataEngineFutureStub(channel, callOptions);
        }
      };
    return DataEngineFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void readData(dataengine.DataEngineService.ReadDataRequest request,
        io.grpc.stub.StreamObserver<dataengine.DataEngineService.DataEngineResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadDataMethod(), responseObserver);
    }

    /**
     */
    default void writeData(dataengine.DataEngineService.WriteDataRequest request,
        io.grpc.stub.StreamObserver<dataengine.DataEngineService.DataEngineResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataEngine.
   */
  public static abstract class DataEngineImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DataEngineGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataEngine.
   */
  public static final class DataEngineStub
      extends io.grpc.stub.AbstractAsyncStub<DataEngineStub> {
    private DataEngineStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataEngineStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataEngineStub(channel, callOptions);
    }

    /**
     */
    public void readData(dataengine.DataEngineService.ReadDataRequest request,
        io.grpc.stub.StreamObserver<dataengine.DataEngineService.DataEngineResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeData(dataengine.DataEngineService.WriteDataRequest request,
        io.grpc.stub.StreamObserver<dataengine.DataEngineService.DataEngineResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataEngine.
   */
  public static final class DataEngineBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataEngineBlockingStub> {
    private DataEngineBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataEngineBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataEngineBlockingStub(channel, callOptions);
    }

    /**
     */
    public dataengine.DataEngineService.DataEngineResponse readData(dataengine.DataEngineService.ReadDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public dataengine.DataEngineService.DataEngineResponse writeData(dataengine.DataEngineService.WriteDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataEngine.
   */
  public static final class DataEngineFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataEngineFutureStub> {
    private DataEngineFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataEngineFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataEngineFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dataengine.DataEngineService.DataEngineResponse> readData(
        dataengine.DataEngineService.ReadDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dataengine.DataEngineService.DataEngineResponse> writeData(
        dataengine.DataEngineService.WriteDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READ_DATA = 0;
  private static final int METHODID_WRITE_DATA = 1;

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
        case METHODID_READ_DATA:
          serviceImpl.readData((dataengine.DataEngineService.ReadDataRequest) request,
              (io.grpc.stub.StreamObserver<dataengine.DataEngineService.DataEngineResponse>) responseObserver);
          break;
        case METHODID_WRITE_DATA:
          serviceImpl.writeData((dataengine.DataEngineService.WriteDataRequest) request,
              (io.grpc.stub.StreamObserver<dataengine.DataEngineService.DataEngineResponse>) responseObserver);
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
          getReadDataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dataengine.DataEngineService.ReadDataRequest,
              dataengine.DataEngineService.DataEngineResponse>(
                service, METHODID_READ_DATA)))
        .addMethod(
          getWriteDataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dataengine.DataEngineService.WriteDataRequest,
              dataengine.DataEngineService.DataEngineResponse>(
                service, METHODID_WRITE_DATA)))
        .build();
  }

  private static abstract class DataEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataEngineBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dataengine.DataEngineService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataEngine");
    }
  }

  private static final class DataEngineFileDescriptorSupplier
      extends DataEngineBaseDescriptorSupplier {
    DataEngineFileDescriptorSupplier() {}
  }

  private static final class DataEngineMethodDescriptorSupplier
      extends DataEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataEngineMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataEngineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataEngineFileDescriptorSupplier())
              .addMethod(getReadDataMethod())
              .addMethod(getWriteDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
