package pl.janowski.raportmodule.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.janowski.raportmodule.Service.EmployeeReportService;

@RestController
public class EmployeeReportController {
    private EmployeeReportService employeeReportService;


    public EmployeeReportController(EmployeeReportService employeeReportService) {
        this.employeeReportService = employeeReportService;
    }

    @GetMapping("/employees")
    public ResponseEntity<String> getEmployeeCount() {
        int employeeCount = employeeReportService.countEmployees();
        String message = "Od początku istienia naszej firmie, pracuje/pracowało " + employeeCount + " uśmiechniętych pracowników";
        return ResponseEntity.ok().body("{\"message\":\"" + message + "\"}");
    }
}



