package mx.com.cj.controlingresosygastos.entity;

import javax.persistence.*;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id")
    private Long cuentaId;

    @Column(name = "institucion_financiera", nullable = false)
    private String institucionFinanciera;

    @Column(name = "tipo_cuenta", nullable = false)
    private String tipoCuenta;

    @Column(name = "saldo_inicial", nullable = false)
    private Double saldoInicial;

    @Column(name = "saldo_actual", nullable = false)
    private Double saldoActual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarios_cuentas"))
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
