package com.EmployeeApp.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by abarajas on 6/20/17.
 */
@Path("/employees")
public class EmployeeResource {
    // Make this resource per-request, stateless
    private EmployeeResourceService employeeResourceService;

    public EmployeeResource() {
        initializeDependencies();
    }

    private void initializeDependencies() {
        employeeResourceService = new EmployeeResourceService();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getEmployee(@PathParam("id") Long id) {
        EmployeeRepresentation representation = employeeResourceService.getEmployeeById(id);
        if (representation != null) {
//            return representation;
            Response.ResponseBuilder ok = Response.ok();
            ok.entity(representation).build();
            return ok.build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createEmployee(EmployeeRepresentation representation) {
        EmployeeRepresentation employee = employeeResourceService.createEmployeeWithNewId(representation);
        return Response.created(URI.create("/employees/" + employee.getId())).entity(employee).build();

    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateEmployee(@PathParam("id") Long id, EmployeeRepresentation representation) {
        EmployeeRepresentation employeeWithUpdatedFields = employeeResourceService.getEmployeeById(id);
        if (employeeWithUpdatedFields == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            if (representation != null) {
                EmployeeRepresentation updatedEmployee = employeeResourceService.updateEmployeeById(id, representation);
                return Response.ok().entity(updatedEmployee).build();
            } else {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }

//    @GET
//    @Produces("text/plain")
//    public String hello() {
//        return "Hello Ana!";
//    }
}
