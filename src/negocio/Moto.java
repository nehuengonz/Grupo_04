package negocio;

public class Moto extends Vehiculo{
	private static final double cant_max_pasajeros =1;
    public Moto(String nropatente) {
		super(nropatente,cant_max_pasajeros, false, false);
	}

	@Override
	public String toString() {
		return "Moto [toString()=" + super.toString() + "]";
	}
	
}