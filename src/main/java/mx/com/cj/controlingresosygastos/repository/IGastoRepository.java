package mx.com.cj.controlingresosygastos.repository;

import mx.com.cj.controlingresosygastos.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGastoRepository extends JpaRepository<Gasto, Long> {
}
