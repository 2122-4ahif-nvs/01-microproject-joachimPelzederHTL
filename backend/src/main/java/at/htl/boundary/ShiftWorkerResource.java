package at.htl.boundary;

import at.htl.control.ShiftWorkerRepository;
import at.htl.entity.Shift;
import at.htl.entity.ShiftWorker;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("shiftworker")
@GraphQLApi
public class ShiftWorkerResource {

    @Inject
    ShiftWorkerRepository shiftWorkerRepository;

    @Query("allShiftWorkers")
    @Description("Get all Workers")
    public List<ShiftWorker> getAllWorkers(){
        return shiftWorkerRepository.findAll().list();
    }

    @Query
    @Description("Get a worker by it's id")
    @Path("{workerId}")
    public ShiftWorker getWorker(@Name("workerId") Long id){
        return shiftWorkerRepository.findById(id);
    }
}
