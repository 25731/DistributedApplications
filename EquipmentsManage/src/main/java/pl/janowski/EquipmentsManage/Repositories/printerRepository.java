package pl.janowski.EquipmentsManage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.janowski.EquipmentsManage.Entity.Printer;

@Repository
public interface printerRepository extends JpaRepository<Printer, Long> {


}
