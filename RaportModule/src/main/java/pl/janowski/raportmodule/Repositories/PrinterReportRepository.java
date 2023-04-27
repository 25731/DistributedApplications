package pl.janowski.raportmodule.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.janowski.raportmodule.Entity.PrinterReport;

@Repository
public interface PrinterReportRepository extends JpaRepository<PrinterReport, Long> {
}
