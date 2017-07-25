package com.EmployeeApp.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    public EmployeeRepresentation getEmployee(@PathParam("id") Long id) {
        EmployeeRepresentation representation = employeeResourceService.getEmployeeById(id);
        if (representation != null) {
            return representation;
//            Response.ResponseBuilder ok = Response.ok();
//            ok.entity(representation).build();
//            ok.build();
        } else {
            throw new WebApplicationException(404);
        }
    }

//    @GET
//    @Produces("text/plain")
//    public String hello() {
//        return "Hello Ana!";
//    }
}
