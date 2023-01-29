package mx.com.cj.controlingresosygastos.repository;

import mx.com.cj.controlingresosygastos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByEmail(String email);

}
