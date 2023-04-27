package pl.janowski.raportmodule.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.janowski.raportmodule.Entity.EmployeeReport;
import pl.janowski.raportmodule.Entity.PrinterReport;

@Repository
public interface EmployeeReportRepository extends JpaRepository<EmployeeReport, Long> {
  void save(PrinterReport printerReport);
}
