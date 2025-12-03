package edu.ubicua.repositorio.memoria;

import edu.ubicua.logica.PresupuestoMensual;
import edu.ubicua.repositorio.PresupuestoRepository;
import java.util.ArrayList;
import java.util.List;

public class PresupuestoRepositoryInMemory implements PresupuestoRepository{
private final List<PresupuestoMensual> presupuestos = new ArrayList<>();

    @Override
    public PresupuestoMensual guardar(PresupuestoMensual presupuesto) {
        presupuestos.add(presupuesto);
        return presupuesto;
    }

    @Override
    public PresupuestoMensual buscarPorAnioYMes(int anio, int mes) {
        for (PresupuestoMensual p : presupuestos) {
            if (p.getAnio() == anio && p.getMes() == mes) {
                return p;
            }
        }
        return null;
    }
}
