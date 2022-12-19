package mx.com.cj.controlingresosygastos.service;

import mx.com.cj.controlingresosygastos.dto.IngresoDTO;

import java.util.List;
import java.util.Optional;

public interface IIngresoService {
    List<IngresoDTO> findAll();

    Optional<IngresoDTO> findById(long id);

    IngresoDTO save(IngresoDTO ingresoDTO);

    void update(long id, IngresoDTO ingresoDTO) throws Exception;

    void delete(long id) throws Exception;
}
