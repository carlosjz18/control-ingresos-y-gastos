package mx.com.cj.controlingresosygastos.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IngresoDTO {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private Long ingresoId;


    private String descripcion;
    private Double monto;
    private LocalDate fecha;
    private String categoria;
    private CuentaDTO cuenta;
}
