package mx.com.cj.controlingresosygastos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @Email(message = "El correo debe ser valido")
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String contrasena;

    @NotBlank(message = "El rol no puede estar vacío")
    private String rol;

    /*public String getContrasena() {
        return null;
    }*/
}
