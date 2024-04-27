package negocio;

public class ChoferContratado extends Chofer{
    protected double ganancia_viaje;


    
    public ChoferContratado(String dni, String nombre, double ganancia_viaje) {
		super(dni, nombre);
		this.ganancia_viaje = ganancia_viaje;
	}
	public ChoferContratado() {
        super();
    }
    public void setGanancia_viaje(double ganancia_viaje) {
        this.ganancia_viaje = ganancia_viaje;
    }

    public double getGanancia_viaje() {
        return ganancia_viaje;
    }


    @Override
    public double getSueldoBruto() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public double getSueldoNeto() {
        // TODO Implement this method
        return 0.0;
    }
	@Override
	public String toString() {
		return "ChoferContratado [ganancia_viaje=" + ganancia_viaje + ", dni=" + dni + ", nombre=" + nombre + "]";
	}
    
}