package com.dhineshkanna.dkgt;

import org.springframework.context.ApplicationContext;

import com.dhineshkanna.dkgt.ServiceLayour.AppService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DkgtApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DkgtApplication.class, args);
		AppService service = context.getBean(AppService.class);
		service.SaveDetails();
		service.getDetailsAdd();
	}

}
