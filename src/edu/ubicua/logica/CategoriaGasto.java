package edu.ubicua.logica;

public class CategoriaGasto {
    private int codCategoriaGasto;
    private String nombre;
    private String tipo;

    public CategoriaGasto() {
    }

    public CategoriaGasto(int codCategoriaGasto, String nombre, String tipo) {
        this.codCategoriaGasto = codCategoriaGasto;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getCodCategoriaGasto() {
        return codCategoriaGasto;
    }

    public void setCodCategoriaGasto(int codCategoriaGasto) {
        this.codCategoriaGasto = codCategoriaGasto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "CategoriaGasto{" + "codCategoriaGasto=" + codCategoriaGasto + ", nombre=" + nombre + ", tipo=" + tipo + '}';
    }
    
    
            
}
