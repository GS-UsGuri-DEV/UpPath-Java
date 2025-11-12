package br.com.fiap.resource;

import br.com.fiap.TO.UserTrial;
import br.com.fiap.bo.UserTrialBO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/usertrials")
public class UserTrialResource {
    private UserTrialBO userTrialBO = new UserTrialBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<UserTrial> result = userTrialBO.findAll();
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        UserTrial result = userTrialBO.findById(id);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(UserTrial userTrial) {
        UserTrial result = userTrialBO.save(userTrial);
        Response.ResponseBuilder response = (result != null) ? Response.created(null) : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid UserTrial userTrial, @PathParam("id") Long id) {
        userTrial.setIdTrial(id);
        UserTrial result = userTrialBO.update(userTrial);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = userTrialBO.delete(id) ? Response.ok() : Response.status(404);
        return response.build();
    }
}
