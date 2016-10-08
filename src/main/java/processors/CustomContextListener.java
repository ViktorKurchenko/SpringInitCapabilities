package processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Custom Spring context listener
 */
public class CustomContextListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomContextListener.class);


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOGGER.info("Post-Construction Phase 5 [into Context Listener]");
	}

}
