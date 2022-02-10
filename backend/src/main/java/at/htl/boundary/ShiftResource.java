package at.htl.boundary;

import at.htl.control.ShiftRepository;
import at.htl.entity.Shift;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("shift")
public class ShiftResource {

    @Inject
    ShiftRepository shiftRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance shift(Shift shift);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shift> getAllShifts(){
        return shiftRepository.findAll().list();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@PathParam("id") Long id){
        return Templates.shift(shiftRepository.findById(id));
    }
}
