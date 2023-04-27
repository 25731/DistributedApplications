package pl.janowski.raportmodule.Service;

import org.springframework.stereotype.Service;
import pl.janowski.raportmodule.Entity.PrinterReport;
import pl.janowski.raportmodule.Repositories.PrinterReportRepository;

import java.util.List;

@Service
public class PrinterReportService {
    private  PrinterReportRepository printerReportRepository;

    public PrinterReportService(PrinterReportRepository printerReportRepository) {
        this.printerReportRepository = printerReportRepository;
    }

    public int countPrinters() {
        List<PrinterReport> printers = printerReportRepository.findAll();
        return printers.size();
    }
}

