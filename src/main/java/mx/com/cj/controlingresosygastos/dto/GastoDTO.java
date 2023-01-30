package mx.com.cj.controlingresosygastos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GastoDTO {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private Long gastoId;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 45, message = "La descripción debe tener al menos 5 letras y ser menor a 45")
    private String descripcion;

    @NotBlank(message = "El monto no puede estar vacío")
    @DecimalMin(value = "0.00")
    private Double monto;

    @NotBlank(message = "La fecha no puede estar vacía")
    private LocalDate fecha;

    @NotBlank(message = "La categoría no puede estar vacía")
    @Size(min = 5, max = 45, message = "La categoría debe tener al menos 5 letras y ser menor a 45")
    private String categoria;

    @NotBlank(message = "La cuenta no puede estar vacía")
    private CuentaDTO cuenta;
}
