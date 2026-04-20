package presentacion;

import logica.*;
import modelo.*;

public class PruebaVentaCafeteria {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("  PRUEBA 3: VENTA CAFETERÍA");
        System.out.println("====================================\n");

        Cafe cafe = new Cafe(30);
        GestorUsuarios gestorUsuarios = new GestorUsuarios(cafe);
        GestorInventario gestorInventario = new GestorInventario(cafe);
        GestorVentas gestorVentas = new GestorVentas(cafe);
        GestorPrestamos gestorPrestamos = new GestorPrestamos(cafe);

        Bebida cafe1 = new Bebida("Café Americano", 5000, false, true);
        Bebida cerveza = new Bebida("Cerveza", 8000, true, false);
        Pasteleria brownie = new Pasteleria("Brownie de chocolate", 6000);
        brownie.agregarAlergeno("gluten");
        brownie.agregarAlergeno("maní");

        gestorInventario.agregarProductoCafeteria(cafe1, 10);
        gestorInventario.agregarProductoCafeteria(cerveza, 10);
        gestorInventario.agregarProductoCafeteria(brownie, 5);

        Cliente cliente = gestorUsuarios.registrarCliente("laura22", "pass");
        Mesa mesa = gestorPrestamos.crearMesa(2, false, false, cliente);

        System.out.println("\n--- Caso 1: Venta normal ---");
        Venta venta = gestorVentas.iniciarVentaCafeteria(cliente);
        gestorVentas.agregarProductoAVenta(venta, cafe1, 1, mesa);
        gestorVentas.agregarProductoAVenta(venta, brownie, 2, mesa);
        gestorVentas.finalizarVenta(venta);

        System.out.println("\n--- Caso 2: Bebida alcohólica con menores ---");
        Mesa mesaMenores = gestorPrestamos.crearMesa(3, false, true, cliente);
        Venta venta2 = gestorVentas.iniciarVenta