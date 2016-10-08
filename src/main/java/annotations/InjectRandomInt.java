package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

	int min();

	int max();

}
