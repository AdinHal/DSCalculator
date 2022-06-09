package aufgabe2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class Calculator {
    final String er = "r";
    final String eh = "h";
    @GET
    @Path("/surface")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateSurface(@PathParam(er) double r, @PathParam(eh) double h){
        return "The Surface Area of the Cylinder is: "+((2*Math.PI*Math.pow(r,2))+(2*Math.PI*r*h));
    }
}
