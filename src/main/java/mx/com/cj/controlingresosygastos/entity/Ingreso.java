package mx.com.cj.controlingresosygastos.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ingresos")
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingreso_id")
    private Long ingresoId;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cuentas_ingresos"))
    private Cuenta cuenta;

    public Ingreso() {
    }

    public Ingreso(Long ingresoId, String descripcion, Double monto, LocalDate fecha, String categoria, Cuenta cuenta) {
        this.ingresoId = ingresoId;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
        this.cuenta = cuenta;
    }

    public Long getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(Long ingresoId) {
        this.ingresoId = ingresoId;
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
