package at.htl.boundary;

import at.htl.control.EmployeeRepository;
import at.htl.entity.Employee;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.ws.rs.*;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result tryMeManualValidation(Employee employee){
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        if(violations.isEmpty()){
            return new Result("Employee is valid! It was validated by manual validation.");
        } else {
            return new Result(violations);
        }
    }

    @Path("/end-point-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result tryMeEndPointMethodValidation(@Valid Employee employee){
        return new Result("Employee is valid! It was validated by end point method validation.");
    }

    @Path("/repository-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result tryMeServiceMethodValidation(Employee employee){
        try {
            employeeRepository.persist(employee);
            return new Result("Employee is valid! It was validated by service method validation.");
        } catch (ConstraintViolationException e){
            return new Result(e.getConstraintViolations());
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
