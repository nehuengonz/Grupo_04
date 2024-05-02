package negocio;

public class ViajeConBaul implements Iviaje {
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.05;
    private Iviaje viaje;
    /* 
    public ViajeConBaul(ViajeAbstract viaje) {
        super(viaje);
    }
     */
    public ViajeConBaul(Iviaje viaje){
        this.viaje=viaje;
    }

    @Override
    public double getkm() {
        return viaje.getkm();
    }


    @Override
    public void getCalificacionDelChofer() {

    }



    @Override
    public double getCosto() {
       return viaje.getCosto()*
       (aumento_por_pasajero*viaje.getpasajeros())*
       (aumento_por_km)*viaje.getkm();
    }

	@Override
	public double getpasajeros() {
		// TODO Auto-generated method stub
		return viaje.getpasajeros();
	}
}
