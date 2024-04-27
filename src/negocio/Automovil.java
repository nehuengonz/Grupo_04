package negocio;

public class Automovil extends Vehiculo{
	private static final double cant_max_pasajeros =4;
	
    public Automovil(String nropatente) {
		super(nropatente,cant_max_pasajeros,true, true);
	}

	public Automovil() {
        super();
    }

	@Override
	public String toString() {
		return "Automovil [toString()=" + super.toString() + "]";
	}
	
	
}