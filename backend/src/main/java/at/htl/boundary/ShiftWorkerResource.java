package at.htl.boundary;

import at.htl.control.ShiftWorkerRepository;
import at.htl.entity.ShiftWorker;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("shiftworker")
public class ShiftWorkerResource {

    @Inject
    ShiftWorkerRepository shiftWorkerRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShiftWorker> getAll(){
        return shiftWorkerRepository.findAll().list();
    }
}
