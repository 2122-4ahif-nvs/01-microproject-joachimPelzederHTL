package at.htl.boundary;

import at.htl.control.WorkstationRepository;
import at.htl.entity.Workstation;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.graphql.api.Subscription;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("workstation")
@GraphQLApi
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

    BroadcastProcessor<Workstation> processor = BroadcastProcessor.create();

    @Mutation
    public Workstation createWorkstation(Workstation workstation){
        workstationRepository.persist(workstation);
        processor.onNext(workstation);
        return workstation;
    }

    @Subscription
    public Multi<Workstation> workstationCreated(){
        return processor;
    }

    @Mutation
    public Workstation deleteWorkstation(Workstation workstation){
        workstationRepository.delete(workstation);
        return workstation;
    }

    @Query
    public List<Workstation> getByName(@DefaultValue("Hobelbank") String stationName){
        return workstationRepository.getByName(stationName);
    }
}
