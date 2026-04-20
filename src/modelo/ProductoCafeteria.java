package modelo;

public abstract class ProductoCafeteria {
    private String nombre;
    private double precio;

    public ProductoCafeteria(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Producto[nombre=" + nombre + ", precio=" + precio + "]";
    }
}