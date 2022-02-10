package at.htl.control;

import at.htl.entity.Shift;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShiftRepository implements PanacheRepository<Shift> {
}
