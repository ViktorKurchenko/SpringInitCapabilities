package processors;

import annotations.InjectRandomInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Custom Bean Post Processor
 */
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

	private static final Logger LOGGER = LoggerFactory.getLogger(InjectRandomIntBeanPostProcessor.class);


	@Override
	public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
		LOGGER.info("Pre-Construction before init Phase 1 [into BeanPostProcessor]");
		Field[] fields = o.getClass().getDeclaredFields();
		for (Field field : fields) {
			InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
			if (annotation != null) {
				int min = annotation.min();
				int max = annotation.max();
				if (min > max) {
					throw new RuntimeException("Wrong bounds!!!");
				}
				int random = min + new Random().nextInt(max - min);
				field.setAccessible(true);
				ReflectionUtils.setField(field, o, random);
			}
		}
		return o;
	}

	@Override
	public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
		LOGGER.info("Pre-Construction after init Phase 2 [into BeanPostProcessor]");
		return o;
	}
}
