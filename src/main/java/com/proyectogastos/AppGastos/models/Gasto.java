package com.proyectogastos.AppGastos.models;
import java.util.Date;
public class Gasto {

    private Long idGasto;
    private String descripcion;
    private double monto;
    private String categoria;
    private Date Fecha;
    private String tipo;

    public Gasto()
    {

    }



    public Gasto(Long idGasto, String descripcion, double monto, String categoria, Date fecha, String tipo) {
        this.idGasto = idGasto;
        this.descripcion = descripcion;
        this.monto = monto;
        this.categoria = categoria;
        this.Fecha = fecha;
        this.tipo = tipo;
    }

    public Long getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Long idGasto) {
        this.idGasto = idGasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
