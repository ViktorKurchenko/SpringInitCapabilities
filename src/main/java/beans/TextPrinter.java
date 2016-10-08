package beans;

import annotations.InjectRandomInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TextPrinter implements Printer, InitializingBean, DisposableBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(TextPrinter.class);

	@InjectRandomInt(min = 2, max = 7)
	private int repeat;

	private String text;


	public TextPrinter() {
		LOGGER.info("Construction Phase 2 [into default constructor]");
	}

	@Override
	public void print() {
		for (int i = 0; i < repeat; i++) {
			System.out.println(text);
		}
	}

	@PostConstruct
	public void postConstruct() {
		LOGGER.info("Post-Construction Phase 3 [into PostConstruct annotated method]");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOGGER.info("Post-Construction Phase 4 [into afterPropertiesSet method]");
	}

	public void init() {
		LOGGER.info("Post-Construction Phase 5 [into init method]");
	}

	@PreDestroy
	public void preDestroy() {
		LOGGER.info("Pre-Destroy Phase 1 [into PreDestroy annotated method]");
	}

	@Override
	public void destroy() {
		LOGGER.info("Pre-Destroy Phase 2 [into destroy method]");
	}

	public void manualXmlDestroy() {
		LOGGER.info("Pre-Destroy Phase 3 [into manualXmlDestroy method]");
	}

	public void setText(String text) {
		this.text = text;
	}
}
