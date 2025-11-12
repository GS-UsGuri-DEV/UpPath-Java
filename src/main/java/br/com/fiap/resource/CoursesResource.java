        package br.com.fiap.resource;

import br.com.fiap.TO.Courses;
import br.com.fiap.bo.CoursesBO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/courses")
public class CoursesResource {
    private CoursesBO coursesBO = new CoursesBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<Courses> result = coursesBO.findAll();
        Response.ResponseBuilder response = null;

        if (result != null) {
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(result);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        Courses result = coursesBO.findById(id);
        Response.ResponseBuilder response = null;

        if (result != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }

        response.entity(result);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Courses course) {
        Courses result = coursesBO.save(course);
        Response.ResponseBuilder response = null;

        if (result != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(result);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;

        if (coursesBO.delete(id)) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }

        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid Courses course, @PathParam("id") Long id ) {
        course.setIdCourse(id);
        Courses result = coursesBO.update(course);
        Response.ResponseBuilder response = null;

        if (result != null) {
            response = Response.ok();
        } else {
            response = Response.status(400);
        }

        response.entity(result);
        return response.build();

    }
}
