package aufgabe2;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;

// Had to rename it to aufgabe2.ClientSide due to the jersey.api.client.Client;
public class ClientSide {
    static final String URI = "http://localhost:8080/calculator";
    static final String PATH = "calculator/surface";
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);
        WebResource service = client.resource(URI);

        WebResource addService = service.path(PATH).path(a + "/" + b);
        System.out.println("Add Response: " + getResponse(addService));
        System.out.println("Add Output as XML: " + getOutputAsXML(addService));
        System.out.println("Add Output as Text: " + getOutputAsText(addService));
    }

    private static String getOutputAsText(WebResource service) {
        return service.accept(MediaType.TEXT_PLAIN).get(String.class);
    }

    private static String getResponse(WebResource service) {
        return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
    }

    private static String getOutputAsXML(WebResource service) {
        return service.accept(MediaType.TEXT_XML).get(String.class);
    }
}
