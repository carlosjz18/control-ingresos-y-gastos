package mx.com.cj.controlingresosygastos.mapper;

import mx.com.cj.controlingresosygastos.dto.GastoDTO;
import mx.com.cj.controlingresosygastos.entity.Gasto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IGastoMapper {
    GastoDTO toDTO(Gasto data);

    Gasto toEntity(GastoDTO data);
}
