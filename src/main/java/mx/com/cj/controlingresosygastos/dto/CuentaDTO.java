package mx.com.cj.controlingresosygastos.dto;

import lombok.Data;

@Data
public class CuentaDTO {
    private Long cuentaId;
    private String institucionFinanciera;
    private String tipoCuenta;
    private Double saldoInicial;
    private Double saldoActual;
    private UsuarioDTO usuario;
}
