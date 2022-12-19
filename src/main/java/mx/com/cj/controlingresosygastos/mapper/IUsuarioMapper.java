package mx.com.cj.controlingresosygastos.mapper;

import mx.com.cj.controlingresosygastos.dto.UsuarioDTO;
import mx.com.cj.controlingresosygastos.entity.Usuario;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IUsuarioMapper {
    UsuarioDTO toDTO(Usuario data);

    Usuario toEntity(UsuarioDTO data);
}
