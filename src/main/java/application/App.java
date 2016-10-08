package application;

import beans.Printer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test Application class
 */
public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		context.getBean(Printer.class).print();
		context.destroy();
	}

}
