package mx.com.cj.controlingresosygastos.dto;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Data
public class GastoDTO {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private Long gastoId;


    private String descripcion;
    private Double monto;
    private LocalDate fecha;
    private String categoria;
    private CuentaDTO cuenta;
}
