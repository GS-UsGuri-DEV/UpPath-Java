package br.com.fiap.resource;

import br.com.fiap.TO.WellBeing;
import br.com.fiap.bo.WellBeingBO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/wellBeing")
public class WellBeingResource {
    private WellBeingBO wellBeingBO = new WellBeingBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<WellBeing> result = wellBeingBO.findAll();
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        WellBeing result = wellBeingBO.findById(id);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(WellBeing wellBeing) {
        WellBeing result = wellBeingBO.save(wellBeing);
        Response.ResponseBuilder response = (result != null) ? Response.created(null) : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid WellBeing wellBeing, @PathParam("id") Long id) {
        wellBeing.setIdWellBeing(id);
        WellBeing result = wellBeingBO.update(wellBeing);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = wellBeingBO.delete(id) ? Response.ok() : Response.status(404);
        return response.build();
    }
}
