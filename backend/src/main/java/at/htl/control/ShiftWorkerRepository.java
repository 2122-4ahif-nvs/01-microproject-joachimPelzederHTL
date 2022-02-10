package at.htl.control;

import at.htl.entity.Shift;
import at.htl.entity.ShiftWorker;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ShiftWorkerRepository implements PanacheRepository<ShiftWorker> {

    public List<ShiftWorker> getWorkersByShift(Shift shift){
        return shift.getWorkers();
    }
}
