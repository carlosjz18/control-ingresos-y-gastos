package mx.com.cj.controlingresosygastos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDTO {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private Long usuarioId;

    @NotBlank(message = "El nombre del usuario no puede estar vacío")
    @Size(min = 5, max = 45, message = "El nombre del usuario debe tener al menos 5 letras y ser menor a 45")
    private String nombre;

    @Email
    @NotBlank(message = "El correo no puede estar vacío")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    private String password;

    @NotBlank(message = "El rol no puede estar vacío")
    private String rol;
}
