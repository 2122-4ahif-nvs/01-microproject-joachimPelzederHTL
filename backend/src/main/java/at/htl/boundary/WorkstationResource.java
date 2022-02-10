package at.htl.boundary;

import at.htl.control.WorkstationRepository;
import at.htl.entity.Workstation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("workstation")
public class WorkstationResource {

    @Inject
    WorkstationRepository workstationRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Workstation> getAll(){
        return workstationRepository.findAll().list();
    }
}
