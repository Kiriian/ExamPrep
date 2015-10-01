/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dk.cphbusiness.entity.Facade;
import dk.cphbusiness.entity.Project;
import dk.cphbusiness.entity.ProjectUser;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author sofus
 */
@Path("projects")
public class ProjectRestService
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestService
     */
    Gson gson;

    public ProjectRestService()
    {
        gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(String project)
    {
        Project p = gson.fromJson(project, Project.class);
        Facade.createProject(p);
        return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).entity(gson.toJson(p)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjects()
    {
        return Response.status(Response.Status.OK).entity(gson.toJson(Facade.getAllProjects())).build();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@PathParam("id") long id)
    {
        return Response.status(Response.Status.OK).entity(gson.toJson(Facade.findProject(id))).build();
    }

    @POST
    @Path("{projectID}/{userID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AssignAUserToAProject (@PathParam("projectID")long projectID, @PathParam("userID")long userID)
    {
        return null;
    }
    
}
