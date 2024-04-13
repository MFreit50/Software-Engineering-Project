package usercompute;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class UserComputeEngineServer {
    private final int port;
    private final Server server;

    public UserComputeEngineServer(int port) {
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(new UserComputeEngineServiceImpl())
                .build();
    }

    public UserComputeEngineServer(int port, Server server) {
        this.port = port;
        this.server = server;
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            UserComputeEngineServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        UserComputeEngineServer server = new UserComputeEngineServer(50051);
        server.start();
        server.blockUntilShutdown();
    }
}
