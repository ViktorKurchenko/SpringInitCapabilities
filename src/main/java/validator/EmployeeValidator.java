package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collection;

@Component
public class EmployeeValidator implements I_Validator<Employee> {

    @Autowired
    private Validator validator;


    public Collection<ConstraintViolation<Employee>> validate(Employee employee) {
        return validator.validate(employee);
    }

}
