package modelo;

public class Cocinero extends Empleado {

    public Cocinero(String login, String password, String turnoSemana) {
        super(login, password, turnoSemana);
    }

    @Override
    public String toString() {
        return "Cocinero[login=" + getLogin() + ", turno=" + getTurnoSemana() + "]";
    }
}