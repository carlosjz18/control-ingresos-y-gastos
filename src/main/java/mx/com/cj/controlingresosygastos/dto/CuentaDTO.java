package mx.com.cj.controlingresosygastos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CuentaDTO {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private Long cuentaId;

    @NotBlank(message = "La institución financiera no puede estar vacía")
    @Size(min = 3, max = 45, message = "La institución financiera debe tener al menos 3 letras y ser menor a 45")
    private String institucionFinanciera;

    @NotBlank(message = "El tipo de cuenta no puede estar vacío")
    @Size(min = 5, max = 45, message = "El tipo de cuenta debe tener al menos 5 letras y ser menor a 45")
    private String tipoCuenta;

    @NotBlank(message = "El saldo inicial no puede estar vacío")
    @DecimalMin(value = "0.00")
    private Double saldoInicial;

    @NotBlank(message = "El saldo actual no puede estar vacío")
    @DecimalMin(value = "0.00")
    private Double saldoActual;

    @NotBlank(message = "El usuario no puede estar vacío")
    private UsuarioDTO usuario;
}
