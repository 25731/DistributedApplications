package pl.janowski.raportmodule.Service;

import org.springframework.stereotype.Service;
import pl.janowski.raportmodule.Entity.EmployeeReport;
import pl.janowski.raportmodule.Repositories.EmployeeReportRepository;

import java.util.List;

@Service
public class EmployeeReportService {


    private EmployeeReportRepository employeeReportRepository;

    public EmployeeReportService(EmployeeReportRepository employeeReportRepository) {
        this.employeeReportRepository = employeeReportRepository;
    }

    public int countEmployees() {
        List<EmployeeReport> employees = employeeReportRepository.findAll();
        return employees.size();
    }
}