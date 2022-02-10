package at.htl.boundary;

import at.htl.control.WorkstationRepository;
import at.htl.entity.Workstation;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("workstation")
public class WorkstationResource {

    @Inject
    WorkstationRepository workstationRepository;

    @Inject
    Template workstation;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Workstation> getAll(){
        return workstationRepository.findAll().list();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@PathParam("id") Long id){
        return workstation.data("workstation", workstationRepository.findById(id));
    }
}
