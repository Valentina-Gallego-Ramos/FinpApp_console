package edu.ubicua.logica;

public class PresupuestoMensual {
private int codPresupuestoMensual;
private int anio;
private int mes;
private int montoTotal;

    public PresupuestoMensual() {
    }

    public PresupuestoMensual(int codPresupuestoMensual, int anio, int mes, int montoTotal) {
        this.codPresupuestoMensual = codPresupuestoMensual;
        this.anio = anio;
        this.mes = mes;
        this.montoTotal = montoTotal;
    }

    public int getCodPresupuestoMensual() {
        return codPresupuestoMensual;
    }

    public void setCodPresupuestoMensual(int codPresupuestoMensual) {
        this.codPresupuestoMensual = codPresupuestoMensual;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "PresupuestoMensual{" + "codPresupuestoMensual=" + codPresupuestoMensual + ", anio=" + anio + ", mes=" + mes + ", montoTotal=" + montoTotal + '}';
    }


}
