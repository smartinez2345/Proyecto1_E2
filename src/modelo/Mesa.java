package modelo;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int cantidadPersonas;
    private boolean tieneMenures5;
    private boolean tieneMenures18;
    private Cliente cliente;
    private List<Juego> juegosEnMesa;
    private List<ProductoCafeteria> productosEnMesa;

    public Mesa(int cantidadPersonas, boolean tieneMenures5, boolean tieneMenures18, Cliente cliente) {
        this.cantidadPersonas = cantidadPersonas;
        this.tieneMenures5 = tieneMenures5;
        this.tieneMenures18 = tieneMenures18;
        this.cliente = cliente;
        this.juegosEnMesa = new ArrayList<>();
        this.productosEnMesa = new ArrayList<>();
    }

    public boolean tieneJuegoDeAccion() {
        for (Juego j : juegosEnMesa) {
            if (j.getCategoria().equalsIgnoreCase("ACCION")) return true;
        }
        return false;
    }

    public boolean tieneBebidaCaliente() {
        for (ProductoCafeteria p : productosEnMesa) {
            if (p instanceof Bebida && ((Bebida) p).isEsCaliente()) return true;
        }
        return false;
    }

    public void agregarJuego(Juego j) { juegosEnMesa.add(j); }
    public void agregarProducto(ProductoCafeteria p) { productosEnMesa.add(p); }

    public int getCantidadPersonas() { return cantidadPersonas; }
    public boolean isTieneMenures5() { return tieneMenures5; }
    public boolean isTieneMenures18() { return tieneMenures18; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public List<Juego> getJuegosEnMesa() { return juegosEnMesa; }

    @Override
    public String toString() {
        return "Mesa[personas=" + cantidadPersonas
            + ", menores5=" + tieneMenures5
            + ", menores18=" + tieneMenures18
            + ", cliente=" + (cliente != null ? cliente.getLogin() : "ninguno") + "]";
    }
}