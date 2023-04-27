package pl.janowski.raportmodule.EventConsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import pl.janowski.raportmodule.Entity.EmployeeReport;
import pl.janowski.raportmodule.Repositories.EmployeeReportRepository;

import java.util.function.Consumer;

@Configuration
public class ReportEventEmployeeConsumer {

    private final EmployeeReportRepository employeeReportRepository;

    public ReportEventEmployeeConsumer(EmployeeReportRepository employeeReportRepository) {
        this.employeeReportRepository = employeeReportRepository;
    }

    @Bean
    public Consumer<Message<String>> employeeAddedInput() {
        return message -> {
            String employeeInfo = message.getPayload();
            EmployeeReport employeeReport = new EmployeeReport(null, employeeInfo);
            employeeReportRepository.save(employeeReport);
        };
    }
}
