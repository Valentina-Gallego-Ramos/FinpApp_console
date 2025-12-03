package edu.ubicua.codigo;

import edu.ubicua.repositorio.CategoriaRepository;
import edu.ubicua.repositorio.MovimientoRepository;
import edu.ubicua.repositorio.PresupuestoRepository;
import edu.ubicua.repositorio.memoria.CategoriaRepositoryInMemory;
import edu.ubicua.repositorio.memoria.MovimintoRepositoryInMemory;
import edu.ubicua.repositorio.memoria.PresupuestoRepositoryInMemory;
import edu.ubicua.servicio.FinanzasService;
import edu.ubicua.ui.MenuConsola;

public class App {

    public static void main(String[] args) {
        CategoriaRepository categoriaRepo = new CategoriaRepositoryInMemory();
        MovimientoRepository movimientoRepo = new MovimintoRepositoryInMemory();
        PresupuestoRepository presupuestoRepo = new PresupuestoRepositoryInMemory();

        FinanzasService service = new FinanzasService(categoriaRepo, movimientoRepo, presupuestoRepo);
        MenuConsola menu = new MenuConsola(service);
        menu.iniciar();
    }
}
