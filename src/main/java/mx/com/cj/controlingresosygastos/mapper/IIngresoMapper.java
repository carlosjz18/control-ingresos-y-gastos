package mx.com.cj.controlingresosygastos.mapper;

import mx.com.cj.controlingresosygastos.dto.IngresoDTO;
import mx.com.cj.controlingresosygastos.entity.Ingreso;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IIngresoMapper {
    IngresoDTO toDTO(Ingreso data);

    Ingreso toEntity(IngresoDTO data);
}
