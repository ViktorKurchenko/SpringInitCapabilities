package validator;

import javax.validation.ConstraintViolation;
import java.util.Collection;

public interface I_Validator<T> {

    Collection<ConstraintViolation<Employee>> validate(T object);

}
