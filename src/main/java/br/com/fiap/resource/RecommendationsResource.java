package br.com.fiap.resource;

import br.com.fiap.TO.Recommendations;
import br.com.fiap.bo.RecommendationsBO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/recommendations")
public class RecommendationsResource {
    private RecommendationsBO recommendationsBO = new RecommendationsBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<Recommendations> result = recommendationsBO.findAll();
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        Recommendations result = recommendationsBO.findById(id);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(404);
        response.entity(result);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Recommendations rec) {
        Recommendations result = recommendationsBO.save(rec);
        Response.ResponseBuilder response = (result != null) ? Response.created(null) : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid Recommendations rec, @PathParam("id") Long id) {
        rec.setIdRecommendation(id);
        Recommendations result = recommendationsBO.update(rec);
        Response.ResponseBuilder response = (result != null) ? Response.ok() : Response.status(400);
        response.entity(result);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = recommendationsBO.delete(id) ? Response.ok() : Response.status(404);
        return response.build();
    }
}
