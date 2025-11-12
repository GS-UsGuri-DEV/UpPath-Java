package br.com.fiap.resource;

import br.com.fiap.TO.Trail;
import br.com.fiap.bo.TrailBO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/trails")
public class TrailResource {
    private TrailBO trailBO = new TrailBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<Trail> result = trailBO.findAll();
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        Trail result = trailBO.findById(id);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Trail trail) {
        Trail result = trailBO.save(trail);
        Response.ResponseBuilder response = (result != null) ? Response.created(null) : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid Trail trail, @PathParam("id") Long id) {
        trail.setIdTrial(id);
        Trail result = trailBO.update(trail);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = trailBO.delete(id) ? Response.ok() : Response.status(404);
        return response.build();
    }
}
