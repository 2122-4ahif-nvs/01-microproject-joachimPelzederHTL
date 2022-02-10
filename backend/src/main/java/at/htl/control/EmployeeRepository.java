package at.htl.control;

import at.htl.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {
}
