package pl.janowski.employeemanage.Service;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import pl.janowski.employeemanage.Entity.Employee;
import pl.janowski.employeemanage.MessageProducer.EmployeeEventProducer;
import pl.janowski.employeemanage.Repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private EmployeeEventProducer employeeEventProducer;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeEventProducer employeeEventProducer) {
        this.employeeRepository = employeeRepository;
        this.employeeEventProducer = employeeEventProducer;
    }

    @Retry(name = "default")
    @TimeLimiter(name = "default")
    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        employeeEventProducer.EmployeeAddedInput().apply(savedEmployee);
        return savedEmployee;
    }

    @Retry(name = "default")
    @TimeLimiter(name = "default")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Retry(name = "default")
    @TimeLimiter(name = "default")
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Retry(name = "default")
    @TimeLimiter(name = "default")
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

