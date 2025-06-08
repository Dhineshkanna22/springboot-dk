package net.javaguides.springboot_app;
import org.springframework.context.ApplicationContext;

import net.javaguides.springboot_app.Controller.ProductControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootAppApplication.class, args);
		context.getBean(ProductControl.class);
	}

}

