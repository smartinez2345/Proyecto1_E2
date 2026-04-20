package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prestamo {
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;
    private List<Juego> juegos;
    private Mesa mesa;

    public Prestamo(Mesa mesa) {
        this.fechaPrestamo = new Date();
        this.estado = "ACTIVO";
        this.juegos = new ArrayList<>();
        this.mesa = mesa;
    }

    public void agregarJuego(Juego j) {
        if (juegos.size() < 2) {
            juegos.add(j);
        }
    }

    public void cerrarPrestamo() {
        this.fechaDevolucion = new Date();
        this.estado = "CERRADO";
    }

    public Date getFechaPrestamo() { return fechaPrestamo; }
    public Date getFechaDevolucion() { return fechaDevolucion; }
    public String getEstado() { return estado; }
    public List<Juego> getJuegos() { return juegos; }
    public Mesa getMesa() { return mesa; }

    @Override
    public String toString() {
        return "Prestamo[fecha=" + fechaPrestamo + ", estado=" + estado + ", juegos=" + juegos + "]";
    }
}