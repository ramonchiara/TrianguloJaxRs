package br.pro.ramon.dcs.jaxrs.triangulos;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/triangulos")
public class TrianguloResource {

    @GET
    @Path("/{l1}/{l2}/{l3}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTriangulo(@PathParam("l1") double l1, @PathParam("l2") double l2, @PathParam("l3") double l3) {
        try {
            Triangulo t = new Triangulo(l1, l2, l3);
            return Response.ok(t).build();
        } catch (NaoEhTrianguloException ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{l}")
    public Response getTrianguloEquilatero(@PathParam("l") double l) {
        return Response.seeOther(URI.create("triangulos/" + l + "/" + l + "/" + l)).build();
    }

}
