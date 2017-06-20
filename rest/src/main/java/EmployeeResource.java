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

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void retrieve() {
    }
}
