package mx.com.cj.controlingresosygastos.service.impl;

import mx.com.cj.controlingresosygastos.dto.IngresoDTO;
import mx.com.cj.controlingresosygastos.entity.Ingreso;
import mx.com.cj.controlingresosygastos.mapper.IIngresoMapper;
import mx.com.cj.controlingresosygastos.repository.IIngresoRepository;
import mx.com.cj.controlingresosygastos.service.IIngresoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngresoServiceImpl implements IIngresoService {

    private IIngresoMapper ingresoMapper;
    private IIngresoRepository ingresoRepository;

    public IngresoServiceImpl(IIngresoMapper ingresoMapper, IIngresoRepository ingresoRepository) {
        this.ingresoMapper = ingresoMapper;
        this.ingresoRepository = ingresoRepository;
    }

    @Override
    public List<IngresoDTO> findAll() {
        List<Ingreso> ingresos = ingresoRepository.findAll();
        return ingresos.stream().map(ingresoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<IngresoDTO> findById(long id) {
        Optional<Ingreso> ingreso = ingresoRepository.findById(id);
        Optional<IngresoDTO> ingresoDTO = Optional.empty();
        if (ingreso.isPresent()) {
            ingresoDTO = Optional.of(ingresoMapper.toDTO(ingreso.get()));
        }
        return ingresoDTO;
    }

    @Override
    public IngresoDTO save(IngresoDTO ingresoDTO) {
        Ingreso ingreso = ingresoMapper.toEntity(ingresoDTO);
        return ingresoMapper.toDTO(ingresoRepository.save(ingreso));
    }

    @Override
    public void update(long id, IngresoDTO ingresoDTO) throws Exception {
        Optional<Ingreso> result = ingresoRepository.findById(id);
        if (result.isEmpty()) {
            throw new Exception("No existe ingreso");
        }

        Ingreso ingreso = result.get();
        ingreso.setDescripcion(ingresoDTO.getDescripcion());
        ingreso.setMonto(ingresoDTO.getMonto());
        ingreso.setFecha(ingresoDTO.getFecha());
        ingreso.setCategoria(ingresoDTO.getCategoria());
        ingreso.setCuenta(ingresoMapper.toEntity(ingresoDTO).getCuenta());
        ingresoRepository.save(ingreso);
    }

    @Override
    public void delete(long id) throws Exception {
        Optional<Ingreso> ingreso = ingresoRepository.findById(id);
        if (ingreso.isEmpty()) {
            throw new Exception("No existe ingreso");
        }
        ingresoRepository.deleteById(id);
    }
}
