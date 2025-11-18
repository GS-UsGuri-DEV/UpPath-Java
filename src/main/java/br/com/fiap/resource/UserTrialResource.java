package br.com.fiap.resource;

import br.com.fiap.TO.UserTrial;
import br.com.fiap.bo.UserTrialBO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/userTrials")
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
    @Path("/{idUsuario}/{idTrilha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("idUsuario") Long idUsuario, @PathParam("idTrilha") Long idTrilha) {

        UserTrial result = userTrialBO.findById(idUsuario, idTrilha);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(UserTrial userTrial) {
        UserTrial result = userTrialBO.save(userTrial);
        Response.ResponseBuilder response = (result != null) ? Response.status(201) : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @PUT
    @Path("/{idUsuario}/{idTrilha}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid UserTrial userTrial, @PathParam("idUsuario") Long idUsuario, @PathParam("idTrilha") Long idTrilha) {

        userTrial.setIdUser(idUsuario);
        userTrial.setIdTrial(idTrilha);

        UserTrial result = userTrialBO.update(userTrial);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @DELETE
    @Path("/{idUsuario}/{idTrilha}")
    public Response delete(@PathParam("idUsuario") Long idUsuario, @PathParam("idTrilha") Long idTrilha) {
        boolean deleted = userTrialBO.delete(idUsuario, idTrilha);
        Response.ResponseBuilder response = deleted ? Response.ok() : Response.status(404);
        return response.build();
    }
}
