package mx.com.cj.controlingresosygastos.service;

import mx.com.cj.controlingresosygastos.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<UsuarioDTO> findAll();

    Optional<UsuarioDTO> findById(long id);

    UsuarioDTO save(UsuarioDTO usuarioDTO);

    void update(long id, UsuarioDTO usuarioDTO) throws Exception;

    void delete(long id);
}
