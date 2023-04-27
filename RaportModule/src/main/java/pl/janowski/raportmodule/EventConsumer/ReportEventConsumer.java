package pl.janowski.raportmodule.EventConsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import pl.janowski.raportmodule.Entity.PrinterReport;
import pl.janowski.raportmodule.Repositories.PrinterReportRepository;
import java.util.function.Consumer;

@Configuration
public class ReportEventConsumer {
    private final PrinterReportRepository printerReportRepository;

    public ReportEventConsumer(PrinterReportRepository printerReportRepository) {
        this.printerReportRepository = printerReportRepository;
    }

    @Bean
    public Consumer<Message<String>> printerAddedInput() {
        return message -> {
            String printerInfo = message.getPayload();
            PrinterReport printer = new PrinterReport(null, printerInfo);
            printerReportRepository.save(new PrinterReport());
        };
    }
}


