package edu.ubicua.logica;

import java.time.LocalDate;

public class Movimiento {

    private int codMovimiento;
    private String tipo;
    private double monto;
    private LocalDate fecha;
    private String descripcion;
    private CategoriaGasto categoria;

    public Movimiento() {
    }

    public Movimiento(int codMovimiento, String tipo, double monto, LocalDate fecha, String descripcion, CategoriaGasto categoria) {
        this.codMovimiento = codMovimiento;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getCodMovimiento() {
        return codMovimiento;
    }

    public void setCodMovimiento(int codMovimiento) {
        this.codMovimiento = codMovimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaGasto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaGasto categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "codMovimiento=" + codMovimiento + ", tipo=" + tipo + ", monto=" + monto + ", fecha=" + fecha + ", descripcion=" + descripcion + ", categoria=" + categoria + '}';
    }
    
    
}
