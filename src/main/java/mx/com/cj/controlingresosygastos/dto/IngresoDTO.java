package mx.com.cj.controlingresosygastos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IngresoDTO {
    private Long ingresoId;
    private String descripcion;
    private Double monto;
    private LocalDate fecha;
    private String categoria;
    private CuentaDTO cuenta;
}
