package edu.ubicua.ui;

import edu.ubicua.logica.Movimiento;
import edu.ubicua.logica.ResumenMensual;
import edu.ubicua.servicio.FinanzasService;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuConsola {
 private final FinanzasService service;
    private final Scanner teclado = new Scanner(System.in);

    public MenuConsola(FinanzasService service) {
        this.service = service;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1:
                    registrarCategoria();
                    break;
                case 2:
                    registrarMovimiento();
                    break;
                case 3:
                    listarMovimientosMes();
                    break;
                case 4: 
                    verResumenMes();
                    break;
                case 5:
                    configurarPresupuesto();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("===== Gestor de Finanzas Personales =====");
        System.out.println("1. Registrar categoría");
        System.out.println("2. Registrar movimiento (ingreso/gasto)");
        System.out.println("3. Listar movimientos de un mes");
        System.out.println("4. Ver resumen de un mes");
        System.out.println("5. Configurar presupuesto mensual");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    private void registrarCategoria() {
        System.out.print("Nombre de la categoría: ");
        String nombre = teclado.nextLine();
        System.out.print("Tipo (FIJO/VARIABLE): ");
        String tipo = teclado.nextLine();
        service.registrarCategoria(nombre, tipo);
        System.out.println("Categoría registrada.");
    }

    private void registrarMovimiento() {
        System.out.print("Tipo (INGRESO/GASTO): ");
        String tipo = teclado.nextLine();
        System.out.print("Monto: ");
        double monto = Double.parseDouble(teclado.nextLine());
        System.out.print("Fecha (AAAA-MM-DD): ");
        LocalDate fecha = LocalDate.parse(teclado.nextLine());
        System.out.print("ID de categoría: ");
        int categoriaId = Integer.parseInt(teclado.nextLine());
        System.out.print("Descripción: ");
        String descripcion = teclado.nextLine();

        service.registrarMovimiento(tipo, monto, fecha, categoriaId, descripcion);
        System.out.println("Movimiento registrado.");
    }

    private void listarMovimientosMes() {
        System.out.print("Año: ");
        int anio = Integer.parseInt(teclado.nextLine());
        System.out.print("Mes: ");
        int mes = Integer.parseInt(teclado.nextLine());

        List<Movimiento> movimientos = service.listarMovimientosDeMes(anio, mes);
        for (Movimiento m : movimientos) {
            System.out.println(m);
        }
    }

    private void verResumenMes() {
        System.out.print("Año: ");
        int anio = Integer.parseInt(teclado.nextLine());
        System.out.print("Mes: ");
        int mes = Integer.parseInt(teclado.nextLine());

        ResumenMensual r = service.obtenerResumenMensual(anio, mes);
        System.out.println(r);
    }

    private void configurarPresupuesto() {
        System.out.print("Año: ");
        int anio = Integer.parseInt(teclado.nextLine());
        System.out.print("Mes: ");
        int mes = Integer.parseInt(teclado.nextLine());
        System.out.print("Monto de presupuesto: ");
        double monto = Double.parseDouble(teclado.nextLine());

        service.configurarPresupuestoMensual(anio, mes, monto);
        System.out.println("Presupuesto configurado.");
    }
}
