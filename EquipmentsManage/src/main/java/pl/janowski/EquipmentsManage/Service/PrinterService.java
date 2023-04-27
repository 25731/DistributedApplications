package pl.janowski.EquipmentsManage.Service;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import pl.janowski.EquipmentsManage.Entity.Printer;
import pl.janowski.EquipmentsManage.EventSourcing.printerProducer;
import pl.janowski.EquipmentsManage.Repositories.printerRepository;
import java.util.List;

@Service
public class PrinterService {

    private final printerProducer printerProducer;
    private final printerRepository printerRepository;

    public PrinterService(pl.janowski.EquipmentsManage.EventSourcing.printerProducer printerProducer, pl.janowski.EquipmentsManage.Repositories.printerRepository printerRepository) {
        this.printerProducer = printerProducer;
        this.printerRepository = printerRepository;
    }
    @Retry(name = "default")
    @TimeLimiter(name = "default")
    public Printer addPrinter(Printer printer) {
        Printer savedPrinter = printerRepository.save(printer);
        printerProducer.printerAddedInput().apply(savedPrinter);
        return savedPrinter;
    }
    @Retry(name = "default")
    @TimeLimiter(name = "default")
    public void deletePrinter(Long id) {
        printerRepository.deleteById(id);
    }
    @Retry(name = "default")
    @TimeLimiter(name = "default")
    public List<Printer> getAllPrinter() {
        return printerRepository.findAll();
    }
}
