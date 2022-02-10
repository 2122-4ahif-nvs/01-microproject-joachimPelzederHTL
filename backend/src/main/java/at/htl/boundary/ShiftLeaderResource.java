package at.htl.boundary;

import at.htl.control.ShiftLeaderRepository;
import at.htl.entity.ShiftLeader;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("shiftleader")
public class ShiftLeaderResource {

    @Inject
    ShiftLeaderRepository shiftLeaderRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShiftLeader> getAll(){
        return shiftLeaderRepository.findAll().list();
    }
}
