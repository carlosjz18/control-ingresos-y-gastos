package mx.com.cj.controlingresosygastos.repository;

import mx.com.cj.controlingresosygastos.entity.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngresoRepository extends JpaRepository<Ingreso, Long> {
}
