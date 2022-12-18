package mx.com.cj.controlingresosygastos.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gasto_id")
    private Long gastoId;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cuentas_gastos"))
    private Cuenta cuenta;

    public Gasto() {
    }

    public Gasto(Long gastoId, String descripcion, Double monto, LocalDate fecha, String categoria, Cuenta cuenta) {
        this.gastoId = gastoId;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
        this.cuenta = cuenta;
    }

    public Long getGastoId() {
        return gastoId;
    }

    public void setGastoId(Long gastoId) {
        this.gastoId = gastoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
