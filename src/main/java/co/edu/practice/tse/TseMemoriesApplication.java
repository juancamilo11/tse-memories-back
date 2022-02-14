package co.edu.practice.tse;

import co.edu.practice.tse.controllers.UserController;
import co.edu.practice.tse.dtos.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.function.EntityResponse;

@SpringBootApplication
public class TseMemoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TseMemoriesApplication.class, args);
	}

}
