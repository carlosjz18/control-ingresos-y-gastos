package mx.com.cj.controlingresosygastos.mapper;

import mx.com.cj.controlingresosygastos.dto.CuentaDTO;
import mx.com.cj.controlingresosygastos.entity.Cuenta;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ICuentaMapper {
    CuentaDTO toDTO(Cuenta data);

    Cuenta toEntity(CuentaDTO data);
}
