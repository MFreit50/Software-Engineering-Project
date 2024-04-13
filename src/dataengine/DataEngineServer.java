package dataengine;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;

import java.util.concurrent.TimeUnit;

public class DataEngineServer {
    private  Server server;

    public void start() throws Exception {

        int port = 50051;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                .addService(new DataEngineServiceImpl())
                .build()
                .start();
        System.out.println("Data Engine server started on port " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** Shutting down Data Engine server since JVM is shutting down");
                try {
                    if (server != null) {
                        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** Server shut down");
            }
        });
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        DataEngineServer server = new DataEngineServer();
        server.start();
        server.blockUntilShutdown();
    }
}
