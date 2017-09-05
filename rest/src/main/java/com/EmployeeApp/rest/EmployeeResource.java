package com.EmployeeApp.rest;

import com.sun.org.apache.regexp.internal.RE;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by abarajas on 6/20/17.
 */
@Path("/employees")
public class EmployeeResource {
    // Make this resource per-request, stateless
    private static final Logger LOG = Logger.getLogger(EmployeeResource.class.getName());

    private EmployeeResourceService employeeResourceService;

    public EmployeeResource() {
        initializeDependencies();
    }

    private void initializeDependencies() {
        employeeResourceService = new EmployeeResourceService();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getEmployees(){
        List<EmployeeRepresentation> employees = employeeResourceService.getAllEmployees();
        if (employees != null && !employees.isEmpty()) {

            return Response.ok(employees.toArray(new EmployeeRepresentation[employees.size()])).build();
//            GenericEntity<List<EmployeeRepresentation>> entityList =
//                    new GenericEntity<List<EmployeeRepresentation>>(employees){};
//            return Response.ok().entity(entityList).build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getEmployee(@PathParam("id") Long id) {
        EmployeeRepresentation representation = employeeResourceService.getEmployeeById(id);
        if (representation != null) {
            Response.ResponseBuilder ok = Response.ok();
            ok.entity(representation).build();
            return ok.build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createEmployee(EmployeeRepresentation representation) {
        EmployeeRepresentation employee = employeeResourceService.createEmployeeWithNewId(representation);
        return Response.created(URI.create("/employees/" + employee.getId())).entity(employee).build();

    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateEmployee(@PathParam("id") Long existingEmployeeId, EmployeeRepresentation updatedFieldsRepresentation) {
        if (updatedFieldsRepresentation != null) { // TODO::add here validation for representation
            EmployeeRepresentation updatedEmployeeRepresentation = employeeResourceService.updateEmployeeById(existingEmployeeId, updatedFieldsRepresentation);
            return Response.ok().entity(updatedEmployeeRepresentation).build();
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteEmployee(@PathParam("id") Long id) {
        // TODO : add appropriate response when deleted and for errors
        employeeResourceService.deleteEmployeeById(id);
        return Response.noContent().build();
    }
    

//    @GET
//    @Produces("text/plain")
//    public String hello() {
//        return "Hello Ana!";
//    }
}
