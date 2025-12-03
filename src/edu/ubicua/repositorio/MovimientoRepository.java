package edu.ubicua.repositorio;

import edu.ubicua.logica.Movimiento;
import java.time.LocalDate;
import java.util.List;

public interface MovimientoRepository {

    Movimiento guardar(Movimiento movimiento);

    List<Movimiento> obtenerTodos();

    List<Movimiento> buscarPorRangoFecha(LocalDate desde, LocalDate hasta);
}
