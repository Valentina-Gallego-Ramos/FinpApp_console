package edu.ubicua.servicio;

import edu.ubicua.logica.CategoriaGasto;
import edu.ubicua.logica.Movimiento;
import edu.ubicua.logica.PresupuestoMensual;
import edu.ubicua.logica.ResumenMensual;
import edu.ubicua.repositorio.CategoriaRepository;
import edu.ubicua.repositorio.MovimientoRepository;
import edu.ubicua.repositorio.PresupuestoRepository;
import edu.ubicua.util.FechaUtils;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanzasService {

    private final CategoriaRepository categoriaRepo;
    private final MovimientoRepository movimientoRepo;
    private final PresupuestoRepository presupuestoRepo;

    public FinanzasService(CategoriaRepository categoriaRepo,
            MovimientoRepository movimientoRepo,
            PresupuestoRepository presupuestoRepo) {
        this.categoriaRepo = categoriaRepo;
        this.movimientoRepo = movimientoRepo;
        this.presupuestoRepo = presupuestoRepo;
    }

    public void registrarCategoria(String nombre, String tipo) {
        CategoriaGasto cat = new CategoriaGasto(0, nombre, tipo);
        categoriaRepo.guardar(cat);
    }

    public void registrarMovimiento(String tipo, double monto, LocalDate fecha,
            int categoriaId, String descripcion) {
        CategoriaGasto categoria = categoriaRepo.buscarPorId(categoriaId);
        if (categoria == null) {
            System.out.println("Categoría no encontrada");
            return;
        }
        Movimiento mov = new Movimiento(0, tipo, monto, fecha, descripcion, categoria);
        movimientoRepo.guardar(mov);
    }

    public void configurarPresupuestoMensual(int anio, int mes, double monto) {
        PresupuestoMensual p = new PresupuestoMensual(0, anio, mes, (int) monto);
        presupuestoRepo.guardar(p);
    }

    public List<Movimiento> listarMovimientosDeMes(int anio, int mes) {
        LocalDate desde = FechaUtils.inicioDeMes(anio, mes);
        LocalDate hasta = FechaUtils.finDeMes(anio, mes);
        return movimientoRepo.buscarPorRangoFecha(desde, hasta);
    }

    public ResumenMensual obtenerResumenMensual(int anio, int mes) {
        List<Movimiento> movMes = listarMovimientosDeMes(anio, mes);

        double totalIngresos = 0;
        double totalGastos = 0;
        Map<String, Double> gastosPorCat = new HashMap<>();

        for (Movimiento m : movMes) {
            if ("INGRESO".equalsIgnoreCase(m.getTipo())) {
                totalIngresos += m.getMonto();
            } else if ("GASTO".equalsIgnoreCase(m.getTipo())) {
                totalGastos += m.getMonto();
                String nomCat = m.getCategoria().getNombre();
                gastosPorCat.merge(nomCat, m.getMonto(), Double::sum);
            }
        }

        double saldo = totalIngresos - totalGastos;

        PresupuestoMensual p = presupuestoRepo.buscarPorAnioYMes(anio, mes);
        Double presupuestoMensual = (p != null) ? (double) p.getMontoTotal() : null;

        ResumenMensual resumen = new ResumenMensual(anio, mes,
                totalIngresos, totalGastos, saldo, presupuestoMensual);
        resumen.setGastosPorCategoria(gastosPorCat);

        return resumen;
    }
}
