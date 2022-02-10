package at.htl.control;

import at.htl.entity.ShiftWorker;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShiftWorkerRepository implements PanacheRepository<ShiftWorker> {
}
