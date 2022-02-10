package at.htl.boundary;

import at.htl.control.EmployeeRepository;
import at.htl.entity.Employee;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.Result;
import javax.xml.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("employee")
public class EmployeeResource {

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    Validator validator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAll(){
        return employeeRepository.findAll().list();
    }

    @Path("/manual-validation")
    @POST
    public Result tryMeManualValidation(Employee employee){
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        if(violations.isEmpty()){
            return new Result("Employee is valid! It was validated by manual validation.");
        } else {
            return new Result(violations);
        }
    }

    public static class Result{

        private boolean success;
        private String message;

        public Result(String message) {
            this.message = message;
            this.success = true;
        }

        Result(Set<? extends ConstraintViolation<?>> violations){
            this.success = false;
            this.message = violations.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
