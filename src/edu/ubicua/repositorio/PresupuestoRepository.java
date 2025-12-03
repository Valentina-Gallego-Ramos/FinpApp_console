package edu.ubicua.repositorio;

import edu.ubicua.logica.PresupuestoMensual;

public interface PresupuestoRepository {

    PresupuestoMensual guardar(PresupuestoMensual presupuesto);

    PresupuestoMensual buscarPorAnioYMes(int anio, int mes);
}
