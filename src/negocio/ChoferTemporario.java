package negocio;

public class ChoferTemporario extends ChoferEmpleado{

    protected double plus_X_cantidad_viajes;
    protected double cant_viajes;
    
    public double getPlus_X_cantidad_viajes() {
		return plus_X_cantidad_viajes;
	}

	public void setPlus_X_cantidad_viajes(double plus_X_cantidad_viajes) {
		this.plus_X_cantidad_viajes = plus_X_cantidad_viajes;
	}

	public double getCant_viajes() {
		return cant_viajes;
	}

	public void setCant_viajes(double cant_viajes) {
		this.cant_viajes = cant_viajes;
	}

	public ChoferTemporario(double sueldo_basico, double aportes, double plus_X_cantidad_viajes) {
        super();
        this.sueldo_basico = sueldo_basico;
        this.aportes = aportes;
        this.plus_X_cantidad_viajes = plus_X_cantidad_viajes;
        this.cant_viajes=0;
    }

    public ChoferTemporario() {
        super();
    }
    @Override
    public double getSueldoBruto() {
        // TODO Implement this method
        return  sueldo_basico*this.plus_X_cantidad_viajes*cant_viajes;
    }
    @Override
    public double getSueldoNeto() {
        // TODO Implement this method
        return sueldo_basico*this.plus_X_cantidad_viajes*cant_viajes*(1-aportes)*cant_viajes;
    }
}