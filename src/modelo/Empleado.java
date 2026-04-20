package modelo;

public abstract class Empleado extends Usuario {
    private String turnoSemana;
    private double descuento;

    public Empleado(String login, String password, String turnoSemana) {
        super(login, password);
        this.turnoSemana = turnoSemana;
        this.descuento = 0.20;
    }

    public String getTurnoSemana() { return turnoSemana; }
    public void setTurnoSemana(String turnoSemana) { this.turnoSemana = turnoSemana; }
    public double getDescuento() { return descuento; }

    public boolean estaEnTurno() {
        return false;
    }

    @Override
    public String toString() {
        return "Empleado[login=" + getLogin() + ", turno=" + turnoSemana + "]";
    }
}