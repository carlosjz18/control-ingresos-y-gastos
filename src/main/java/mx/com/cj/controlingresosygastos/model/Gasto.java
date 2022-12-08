package mx.com.cj.controlingresosygastos.model;

import java.time.LocalDate;

public class Gasto {

    private Long gastoId;
    private String descripcion;
    private Double monto;
    private LocalDate fecha;
    private String categoria;
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
