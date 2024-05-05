package negocio;

/**
 * clase concreta del chofer temporario extiende de chofer empleado
 */
public class ChoferTemporario extends ChoferEmpleado{

    protected static double plus_X_cantidad_viajes=0.035;
    protected double cant_viajes;
    
    
    public ChoferTemporario(String dni, String nombre, double sueldo_basico, double aportes) {
		super(dni, nombre, sueldo_basico, aportes);
		// TODO Auto-generated constructor stub
	}


	public double getPlus_X_cantidad_viajes() {
		return plus_X_cantidad_viajes;
	}


	public double getCant_viajes() {
		return cant_viajes;
	}

	public void setCant_viajes(double cant_viajes) {
		this.cant_viajes = cant_viajes;
	}

	public ChoferTemporario(double sueldo_basico, double aportes) {
        super();
        this.sueldo_basico = sueldo_basico;
        this.aportes = aportes;
        this.cant_viajes=0;
    }

    public ChoferTemporario() {
        super();
    }

    /**
     * @return el sueldo bruto del chofer
     */
    @Override
    public double getSueldoBruto() {
        // TODO Implement this method
        return  sueldo_basico+ sueldo_basico*(this.plus_X_cantidad_viajes*cant_viajes);
    }

    /**
     * @return el sueldo neto es decir el sueldo bruto - el porcentaje de aportes
     */
    @Override
    public double getSueldoNeto() {
        // TODO Implement this method
        return this.getSueldoBruto()*(1-aportes/100);
    }
}