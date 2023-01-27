package mx.com.cj.controlingresosygastos.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class UsuarioDTO {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private Long usuarioId;

    @NotBlank(message = "El nombre del usuario no puede estar vacío")
    @Size(min = 5, max = 45, message = "El nombre del usuario debe tener al menos 5 letras y ser menor a 45")
    private String nombre;

    @Email
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;

    @Column(name = "contrasena", nullable = false)
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    private String contrasena;
}
