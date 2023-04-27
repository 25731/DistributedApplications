package pl.janowski.employeemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManageApplication.class, args);
	}

}
