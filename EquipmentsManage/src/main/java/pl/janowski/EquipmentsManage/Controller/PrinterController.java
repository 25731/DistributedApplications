package pl.janowski.EquipmentsManage.Controller;
import org.springframework.web.bind.annotation.*;
import pl.janowski.EquipmentsManage.Entity.Printer;
import pl.janowski.EquipmentsManage.Service.PrinterService;

import java.util.List;

@RestController
public class PrinterController {
    private final PrinterService printerService;

    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }


    @PostMapping("/printers")
    public Printer addPrinter(@RequestBody Printer printer) {
        return printerService.addPrinter(printer);
    }

    @DeleteMapping("/printers/{id}")
    public void deletePrinter(@PathVariable Long id) {
        printerService.deletePrinter(id);
    }

    @GetMapping("/printers")
    public List<Printer> getAllPrinter() {
        return printerService.getAllPrinter();
    }
}

