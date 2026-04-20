package modelo;

public class Administrador extends Usuario {

    public Administrador(String login, String password) {
        super(login, password);
    }

    public void gestionarInventario(InventarioJuegos inv, Juego j, int cantidad) {
        inv.actualizarCantidad(cantidad);
    }

    @Override
    public String toString() {
        return "Administrador[login=" + getLogin() + "]";
    }
}