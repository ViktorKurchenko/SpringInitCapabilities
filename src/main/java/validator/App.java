package validator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Collection;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("validator");
        Employee employee = context.getBean(Employee.class);
        Collection<ConstraintViolation<Employee>> violations = context.getBean(EmployeeValidator.class).validate(employee);
        violations.forEach(System.out::println);
    }

}
