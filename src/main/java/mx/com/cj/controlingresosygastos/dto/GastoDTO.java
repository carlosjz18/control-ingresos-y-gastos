package mx.com.cj.controlingresosygastos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GastoDTO {
    private Long gastoId;
    private String descripcion;
    private Double monto;
    private LocalDate fecha;
    private String categoria;
    private CuentaDTO cuenta;
}
