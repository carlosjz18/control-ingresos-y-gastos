package mx.com.cj.controlingresosygastos.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long usuarioId;
    private String nombre;
    private String correo;
    private String contrasena;
}
