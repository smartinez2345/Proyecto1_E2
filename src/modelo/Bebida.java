package modelo;

public class Bebida extends ProductoCafeteria {
    private boolean esAlcoholica;
    private boolean esCaliente;

    public Bebida(String nombre, double precio, boolean esAlcoholica, boolean esCaliente) {
        super(nombre, precio);
        this.esAlcoholica = esAlcoholica;
        this.esCaliente = esCaliente;
    }

    public boolean isEsAlcoholica() { return esAlcoholica; }
    public boolean isEsCaliente() { return esCaliente; }

    public boolean esValidaParaMesa(Mesa mesa) {
        if (esAlcoholica && (mesa.isTieneMenures18() || mesa.isTieneMenures5())) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bebida[nombre=" + getNombre() + ", alcoholica=" + esAlcoholica + ", caliente=" + esCaliente + "]";
    }
}