package validator;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Component
public class Employee {

    @NotNull
    @Min(1)
    @Max(100)
    private Long id;

    @NotNull
    private String name;


    public Employee() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
