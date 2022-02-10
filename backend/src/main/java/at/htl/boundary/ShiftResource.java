package at.htl.boundary;

import at.htl.control.ShiftRepository;
import at.htl.entity.Shift;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("shift")
public class ShiftResource {

    @Inject
    ShiftRepository shiftRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shift> getAllShifts(){
        return shiftRepository.findAll().list();
    }
}
