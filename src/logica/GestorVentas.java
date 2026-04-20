package logica;

import modelo.*;

public class GestorVentas {

    private Cafe cafe;

    public GestorVentas(Cafe cafe) {
        this.cafe = cafe;
    }

    public Venta iniciarVentaCafeteria(Cliente cliente) {
        Venta v = new Venta("CAFETERIA", cliente);
        System.out.println("Venta de cafetería iniciada para: " + cliente.getLogin());
        return v;
    }

    public Venta iniciarVentaJuegos(Cliente cliente) {
        Venta v = new Venta("JUEGOS", cliente);
        System.out.println("Venta de juegos iniciada para: " + cliente.getLogin());
        return v;
    }

    public boolean agregarProductoAVenta(Venta venta, ProductoCafeteria producto,
                                          int cantidad, Mesa mesa) {
        InventarioCafeteria inv = cafe.buscarInventarioCafeteria(producto);
        if (inv == null || inv.getStock() < cantidad) {
            System.out.println("ERROR: Stock insuficiente de " + producto.getNombre());
            return false;
        }

        if (producto instanceof Bebida) {
            Bebida b = (Bebida) producto;
            if (mesa != null && b.isEsAlcoholica() &&
               (mesa.isTieneMenures5() || mesa.isTieneMenures18())) {
                System.out.println("ERROR: No se puede vender bebida alcohólica "
                    + "a mesa con menores de edad.");
                return false;
            }
            if (mesa != null && b.isEsCaliente() && mesa.tieneJuegoDeAccion()) {
                System.out.println("ERROR: No se puede vender bebida caliente "
                    + "a mesa con juego de Acción.");
                return false;
            }
        }

        if (producto instanceof Pasteleria) {
            Pasteleria p = (Pasteleria) producto;
            if (!p.getAlergenos().isEmpty()) {
                System.out.println("ADVERTENCIA: " + producto.getNombre()
                    + " contiene alérgenos: " + p.getAlergenos());
            }
        }

        inv.actualizarStock(-cantidad);
        DetalleVenta detalle = new DetalleVenta(cantidad, producto.getPrecio(), producto);
        venta.agregarDetalle(detalle);
        System.out.println("Producto agregado: " + producto.getNombre() + " x" + cantidad);
        return true;
    }

    public boolean agregarJuegoAVenta(Venta venta, Juego juego, int cantidad,
                                       double precioUnitario) {
        DetalleVenta detalle = new DetalleVenta(cantidad, precioUnitario, null);
        venta.agregarDetalle(detalle);
        System.out.println("Juego agregado a venta: " + juego.getNombre() + " x" + cantidad);
        return true;
    }

    public void aplicarDescuentoCodigo(Venta venta, boolean esEmpleado) {
        if (esEmpleado) {
            venta.setDescuento(0.20);
            System.out.println("Descuento de empleado aplicado: 20%");
        } else {
            venta.setDescuento(0.10);
            System.out.println("Descuento de código aplicado: 10%");
        }
    }

    public void usarPuntosFidelidad(Venta venta, Cliente cliente, int puntos) {
        if (cliente.usarPuntos(puntos)) {
            venta.setDescuentoPuntos(puntos);
            System.out.println("Puntos usados como descuento: $" + puntos);
        } else {
            System.out.println("ERROR: No tiene suficientes puntos.");
        }
    }

    public void finalizarVenta(Venta venta) {
        if (venta.getTipoVenta().equals("CAFETERIA")) {
            venta.setPropinaSugerida();
        }
        cafe.registrarVenta(venta);

        System.out.println("\n===== RESUMEN DE VENTA =====");
        System.out.println("Tipo: " + venta.getTipoVenta());
        System.out.println("Cliente: " + venta.getCliente().getLogin());
        System.out.println("Subtotal: $" + String.format("%.2f", venta.calcularSubtotal()));
        System.out.println("Impuesto: $" + String.format("%.2f", venta.calcularImpuesto()));
        if (venta.getTipoVenta().equals("CAFETERIA")) {
            System.out.println("Propina sugerida: $" + String.format("%.2f", venta.getPropina()));
        }
        System.out.println("TOTAL: $" + String.format("%.2f", venta.calcularTotal()));
        System.out.println("Puntos ganados: " + venta.calcularPuntosFidelidad());
        System.out.println("============================\n");
    }

    public void mostrarHistorialVentas() {
        System.out.println("\n===== HISTORIAL DE VENTAS =====");
        double totalJuegos = 0, totalCafeteria = 0;
        for (Venta v : cafe.getVentas()) {
            System.out.println(v.getFecha() + " | " + v.getTipoVenta()
                + " | Cliente: " + v.getCliente().getLogin()
                + " | Total: $" + String.format("%.2f", v.calcularTotal()));
            if (v.getTipoVenta().equals("JUEGOS")) totalJuegos += v.calcularTotal();
            else totalCafeteria += v.calcularTotal();
        }
        System.out.println("Total ventas juegos: $" + String.format("%.2f", totalJuegos));
        System.out.println("Total ventas cafetería: $" + String.format("%.2f", totalCafeteria));
        System.out.println("================================\n");
    }
}