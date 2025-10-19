package sample.spring.datastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatastoreApplication {

	public static void main(String[] args) {
		System.out.println("Starting Datastore Application...");
		SpringApplication.run(DatastoreApplication.class, args);
		// EmployeeController employeeController = new EmployeeController();

	}

}
