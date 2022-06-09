package aufgabe2;

import com.sun.net.httpserver.HttpServer;
import jakarta.ws.rs.core.UriBuilder;
import jdk.internal.loader.Resource;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;


public class Server {
    public static void main(String[] args) {
        try {
            URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).path("/calculator").build();
            ResourceConfig resourceConfig = new ResourceConfig();
            ResourceConfig config = new ResourceConfig();
            config.packages("com.aufgabe2");
            config.register(Calculator.class);
            HttpServer httpServer = JdkHttpServerFactory.createHttpServer(baseUri, resourceConfig);
            httpServer.start();
            System.out.println("aufgabe2.Server Running!\nPress Enter to stop the server!");
            System.in.read();
            httpServer.stop(0);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
