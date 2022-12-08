package mx.com.cj.controlingresosygastos.model;

public class Cuenta {

    private Long cuentaId;
    private String institucionFinanciera;
    private String tipoCuenta;
    private Double saldoInicial;
    private Double saldoActual;
    private Usuario usuario;

    public Cuenta() {
    }

    public Cuenta(Long cuentaId, String institucionFinanciera, String tipoCuenta, Double saldoInicial, Double saldoActual, Usuario usuario) {
        this.cuentaId = cuentaId;
        this.institucionFinanciera = institucionFinanciera;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
        this.usuario = usuario;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getInstitucionFinanciera() {
        return institucionFinanciera;
    }

    public void setInstitucionFinanciera(String institucionFinanciera) {
        this.institucionFinanciera = institucionFinanciera;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
