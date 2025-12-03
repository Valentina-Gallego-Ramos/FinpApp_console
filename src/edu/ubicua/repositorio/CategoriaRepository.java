package edu.ubicua.repositorio;

import edu.ubicua.logica.CategoriaGasto;
import java.util.List;

public interface CategoriaRepository {

    CategoriaGasto guardar(CategoriaGasto categoria);

    List<CategoriaGasto> obtenerTodas();

    CategoriaGasto buscarPorId(int id);
}
