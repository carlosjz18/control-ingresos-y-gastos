package mx.com.cj.controlingresosygastos.service.impl;

import mx.com.cj.controlingresosygastos.dto.GastoDTO;
import mx.com.cj.controlingresosygastos.entity.Gasto;
import mx.com.cj.controlingresosygastos.mapper.IGastoMapper;
import mx.com.cj.controlingresosygastos.repository.IGastoRepository;
import mx.com.cj.controlingresosygastos.service.IGastoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GastoServiceImpl implements IGastoService {

    private IGastoMapper gastoMapper;
    private IGastoRepository gastoRepository;

    public GastoServiceImpl(IGastoMapper gastoMapper, IGastoRepository gastoRepository) {
        this.gastoMapper = gastoMapper;
        this.gastoRepository = gastoRepository;
    }

    @Override
    public List<GastoDTO> findAll() {
        List<Gasto> gastos = gastoRepository.findAll();
        return gastos.stream().map(gastoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<GastoDTO> findById(long id) {
        Optional<Gasto> gasto = gastoRepository.findById(id);
        Optional<GastoDTO> gastoDTO = Optional.empty();
        if (gasto.isPresent()) {
            gastoDTO = Optional.of(gastoMapper.toDTO(gasto.get()));
        }
        return gastoDTO;
    }

    @Override
    public GastoDTO save(GastoDTO gastoDTO) {
        Gasto gasto = gastoMapper.toEntity(gastoDTO);
        return gastoMapper.toDTO(gastoRepository.save(gasto));
    }

    @Override
    public void update(long id, GastoDTO gastoDTO) throws Exception {
        Optional<Gasto> result = gastoRepository.findById(id);
        if (result.isEmpty()) {
            throw new Exception("No existe gasto");
        }

        Gasto gasto = result.get();
        gasto.setDescripcion(gastoDTO.getDescripcion());
        gasto.setMonto(gastoDTO.getMonto());
        gasto.setFecha(gastoDTO.getFecha());
        gasto.setCategoria(gastoDTO.getCategoria());

        /*Cuenta cuenta = new Cuenta();
        cuenta.setCuentaId(gastoDTO.getCuenta().getCuentaId());*/

        gasto.setCuenta(gastoMapper.toEntity(gastoDTO).getCuenta());
        gastoRepository.save(gasto);
    }

    @Override
    public void delete(long id) throws Exception {
        Optional<Gasto> gasto = gastoRepository.findById(id);
        if (gasto.isEmpty()) {
            throw new Exception("No existe gasto");
        }
        gastoRepository.deleteById(id);
    }
}
