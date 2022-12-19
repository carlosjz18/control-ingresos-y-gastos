package mx.com.cj.controlingresosygastos.service;

import mx.com.cj.controlingresosygastos.dto.CuentaDTO;

import java.util.List;
import java.util.Optional;

public interface ICuentaService {
    List<CuentaDTO> findAll();

    Optional<CuentaDTO> findById(long id);

    CuentaDTO save(CuentaDTO cuentaDTO);

    void update(long id, CuentaDTO cuentaDTO) throws Exception;

    void delete(long id) throws Exception;
}
