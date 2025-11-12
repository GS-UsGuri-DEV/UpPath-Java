package br.com.fiap.resource;

import br.com.fiap.TO.User;
import br.com.fiap.bo.UserBO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/users")
public class UserResource {
    private UserBO userBO = new UserBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<User> result = userBO.findAll();
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        User result = userBO.findById(id);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(User user) {
        User result = userBO.save(user);
        Response.ResponseBuilder response = (result != null) ? Response.created(null) : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid User user, @PathParam("id") Long id) {
        user.setIdUser(id);
        User result = userBO.update(user);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = userBO.delete(id) ? Response.ok() : Response.status(404);
        return response.build();
    }
}
