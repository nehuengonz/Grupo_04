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
    public double getpasajeros() {
        return 0;
    }

    @Override
    public double getkm() {
        return 0;
    }


    @Override
    public void getCalificacionDelChofer() {

    }

    @Override
    public double getDistanciaRecorrida() {
        return 0;
    }

    @Override
    public double getCosto() {
       return viaje.getCosto()*
       (aumento_por_pasajero*viaje.getpasajeros())*
       (aumento_por_km)*viaje.getkm();
    }
}
