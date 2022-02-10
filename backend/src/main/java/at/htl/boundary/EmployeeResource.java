package at.htl.boundary;

import at.htl.control.EmployeeRepository;
import at.htl.entity.Employee;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("employee")
public class EmployeeResource {

    @Inject
    EmployeeRepository employeeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAll(){
        return employeeRepository.findAll().list();
    }
}
