package com.EmployeeApp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by abarajas on 6/20/17.
 */
@Path("/employees")
public class EmployeeResource {
    // Make this resource per-request, stateless
   // private EmployeeResourceService employeeResourceService = new EmployeeResourceService();

//    @GET
//    @Path("/{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public EmployeeRepresentation getEmployee(@PathParam("id") Long id) {
//        EmployeeRepresentation representation = employeeResourceService.getEmployeeById(id);
//        if (representation != null) {
//            return representation;
//        } else {
//            throw new WebApplicationException(Response.Status.NOT_FOUND);
//        }
//    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello world!";
    }
}
