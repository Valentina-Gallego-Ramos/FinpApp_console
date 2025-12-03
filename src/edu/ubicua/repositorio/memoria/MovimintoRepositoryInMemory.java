package edu.ubicua.repositorio.memoria;

import edu.ubicua.logica.Movimiento;
import edu.ubicua.repositorio.MovimientoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovimintoRepositoryInMemory implements MovimientoRepository{
 private final List<Movimiento> movimientos = new ArrayList<>();
    private int secuenciaId = 1;

    @Override
    public Movimiento guardar(Movimiento movimiento) {
        if (movimiento.getCodMovimiento() == 0) {
            movimiento.setCodMovimiento(secuenciaId++);
            movimientos.add(movimiento);
        }
        return movimiento;
    }

    @Override
    public List<Movimiento> obtenerTodos() {
        return new ArrayList<>(movimientos);
    }

    @Override
    public List<Movimiento> buscarPorRangoFecha(LocalDate desde, LocalDate hasta) {
        List<Movimiento> resultado = new ArrayList<>();
        for (Movimiento m : movimientos) {
            if ((m.getFecha().isEqual(desde) || m.getFecha().isAfter(desde))
                    && (m.getFecha().isEqual(hasta) || m.getFecha().isBefore(hasta))) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}
