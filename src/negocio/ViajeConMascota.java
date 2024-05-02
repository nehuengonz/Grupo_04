package negocio;

public class ViajeConMascota implements Iviaje{
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.2;
    private Iviaje viaje;
    /* 
    public ViajeConMascota(ViajeAbstract viaje) {
        super(viaje);
    }
    */
    public ViajeConMascota(Iviaje viaje){
        this.viaje=viaje;
    }

    public double getCosto() {
        return viaje.getCosto()*
        (aumento_por_pasajero*viaje.getpasajeros())*
        (aumento_por_km)*viaje.getkm();
     }

    @Override
    public double getpasajeros() {
        return viaje.getpasajeros();
    }

    @Override
    public double getkm() {
        return 0;
    }


    @Override
    public void getCalificacionDelChofer() {

    }

}
