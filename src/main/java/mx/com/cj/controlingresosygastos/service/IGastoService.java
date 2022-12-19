package mx.com.cj.controlingresosygastos.service;

import mx.com.cj.controlingresosygastos.dto.GastoDTO;

import java.util.List;
import java.util.Optional;

public interface IGastoService {
    List<GastoDTO> findAll();

    Optional<GastoDTO> findById(long id);

    GastoDTO save(GastoDTO gastoDTO);

    void update(long id, GastoDTO gastoDTO) throws Exception;

    void delete(long id) throws Exception;
}
