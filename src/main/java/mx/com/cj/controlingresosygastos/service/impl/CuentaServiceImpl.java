package mx.com.cj.controlingresosygastos.service.impl;

import mx.com.cj.controlingresosygastos.dto.CuentaDTO;
import mx.com.cj.controlingresosygastos.entity.Cuenta;
import mx.com.cj.controlingresosygastos.mapper.ICuentaMapper;
import mx.com.cj.controlingresosygastos.repository.ICuentaRepository;
import mx.com.cj.controlingresosygastos.service.ICuentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaServiceImpl implements ICuentaService {

    private ICuentaMapper cuentaMapper;
    private ICuentaRepository cuentaRepository;

    public CuentaServiceImpl(ICuentaMapper cuentaMapper, ICuentaRepository cuentaRepository) {
        this.cuentaMapper = cuentaMapper;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<CuentaDTO> findAll() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return cuentas.stream().map(cuentaMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CuentaDTO> findById(long id) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        Optional<CuentaDTO> cuentaDTO = Optional.empty();
        if (cuenta.isPresent()) {
            cuentaDTO = Optional.of(cuentaMapper.toDTO(cuenta.get()));
        }
        return cuentaDTO;
    }

    @Override
    public CuentaDTO save(CuentaDTO cuentaDTO) {
        Cuenta cuenta = cuentaMapper.toEntity(cuentaDTO);
        return cuentaMapper.toDTO(cuentaRepository.save(cuenta));
    }

    @Override
    public void update(long id, CuentaDTO cuentaDTO) throws Exception {
        Optional<Cuenta> result = cuentaRepository.findById(id);
        if (result.isEmpty()) {
            throw new Exception("No existe curso");
        }

        Cuenta cuenta = result.get();
        cuenta.setInstitucionFinanciera(cuentaDTO.getInstitucionFinanciera());
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDTO.getSaldoInicial());
        cuenta.setSaldoActual(cuentaDTO.getSaldoActual());

        /*Usuario usuario = Usuario.builder()
                .usuarioId(cuentaDTO.getUsuario().getUsuarioId())
                .nombre(cuentaDTO.getUsuario().getNombre())
                .correo(cuentaDTO.getUsuario().getCorreo())
                .contrasena(cuentaDTO.getUsuario().getContrasena())
                .build();*/

        //cuenta.setUsuario(usuario);
        cuenta.setUsuario(cuentaMapper.toEntity(cuentaDTO).getUsuario());

        cuentaRepository.save(cuenta);
    }

    @Override
    public void delete(long id) throws Exception {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        if (cuenta.isEmpty()) {
            throw new Exception("No existe curso");
        }
        cuentaRepository.deleteById(id);
    }
}
