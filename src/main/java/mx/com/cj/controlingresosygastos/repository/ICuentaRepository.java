package mx.com.cj.controlingresosygastos.repository;

import mx.com.cj.controlingresosygastos.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {
}
