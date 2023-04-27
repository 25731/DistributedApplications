package pl.janowski.raportmodule.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.janowski.raportmodule.Service.PrinterReportService;

@RestController
public class PrinterReportController {
    private  PrinterReportService printerReportService;

    public PrinterReportController(PrinterReportService printerReportService) {
        this.printerReportService = printerReportService;
    }

    @GetMapping("/printers")
    public ResponseEntity<String> getPrinterCount() {
        int printerCount = printerReportService.countPrinters();
        String message = "Od początku istnienia firmy dodano " + printerCount + " drukarek.";
        return ResponseEntity.ok().body("{\"message\":\"" + message + "\"}");
    }
}

