package modelo;

public class DetalleVenta {
    private int cantidad;
    private double precioUnitario;
    private ProductoCafeteria producto;

    public DetalleVenta(int cantidad, double precioUnitario, ProductoCafeteria producto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public ProductoCafeteria getProducto() { return producto; }

    @Override
    public String toString() {
        String nombreProducto = producto != null ? producto.getNombre() : "Juego";
        return "Detalle[producto=" + nombreProducto + ", cantidad=" + cantidad +
               ", precio=" + precioUnitario + ", subtotal=" + calcularSubtotal() + "]";
    }
}