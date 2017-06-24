import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by abarajas on 6/20/17.
 */
@Path("/employees")
public class EmployeeResource {
    // Make this resource per-request, stateless
    private EmployeeResourceService employeeResourceService = new EmployeeResourceService();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieve(@PathParam("id") Long id) {
        EmployeeRepresentation representation = employeeResourceService.retrieveById(id);
        if (representation != null) {

        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return null;
    }
}
