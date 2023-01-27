package mx.com.cj.controlingresosygastos.dto;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
public class CuentaDTO {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private Long cuentaId;


    private String institucionFinanciera;
    private String tipoCuenta;
    private Double saldoInicial;
    private Double saldoActual;
    private UsuarioDTO usuario;
}
