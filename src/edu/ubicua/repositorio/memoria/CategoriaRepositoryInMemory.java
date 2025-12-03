package edu.ubicua.repositorio.memoria;

import edu.ubicua.logica.CategoriaGasto;
import edu.ubicua.repositorio.CategoriaRepository;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryInMemory implements CategoriaRepository{
private final List<CategoriaGasto> categorias = new ArrayList<>();
    private int secuenciaId = 1;

    @Override
    public CategoriaGasto guardar(CategoriaGasto categoria) {
        if (categoria.getCodCategoriaGasto() == 0) {
            categoria.setCodCategoriaGasto(secuenciaId++);
            categorias.add(categoria);
        }
        return categoria;
    }

    @Override
    public List<CategoriaGasto> obtenerTodas() {
        return new ArrayList<>(categorias);
    }

    @Override
    public CategoriaGasto buscarPorId(int id) {
        for (CategoriaGasto c : categorias) {
            if (c.getCodCategoriaGasto() == id) {
                return c;
            }
        }
        return null;
    }
}
