package modelo;

public class Juego {
    private String nombre;
    private int publicacion;
    private String empresaMatriz;
    private String categoria;
    private String estado;
    private boolean esDificil;
    private int maxJugadores;
    private int minJugadores;
    private int edadMinima;

    public Juego(String nombre, int publicacion, String empresaMatriz,
                 String categoria, int minJugadores, int maxJugadores,
                 int edadMinima, boolean esDificil) {
        this.nombre = nombre;
        this.publicacion = publicacion;
        this.empresaMatriz = empresaMatriz;
        this.categoria = categoria;
        this.minJugadores = minJugadores;
        this.maxJugadores = maxJugadores;
        this.edadMinima = edadMinima;
        this.esDificil = esDificil;
        this.estado = "Nuevo";
    }

    public String getNombre() { return nombre; }
    public int getPublicacion() { return publicacion; }
    public String getEmpresaMatriz() { return empresaMatriz; }
    public String getCategoria() { return categoria; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public boolean isEsDificil() { return esDificil; }
    public int getMaxJugadores() { return maxJugadores; }
    public int getMinJugadores() { return minJugadores; }
    public int getEdadMinima() { return edadMinima; }

    public boolean esAptoParaMesa(Mesa mesa) {
        int personas = mesa.getCantidadPersonas();
        if (personas < minJugadores || personas > maxJugadores) return false;
        if (edadMinima >= 18 && mesa.isTieneMenures18()) return false;
        if (edadMinima >= 5 && mesa.isTieneMenures5()) return false;
        return true;
    }

    public boolean esComplejo() { return esDificil; }

    @Override
    public String toString() {
        return "Juego[nombre=" + nombre + ", categoria=" + categoria +
               ", estado=" + estado + ", dificil=" + esDificil + "]";
    }
}