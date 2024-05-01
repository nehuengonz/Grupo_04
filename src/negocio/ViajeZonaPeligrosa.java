package negocio;

public class ViajeZonaPeligrosa extends ViajeDecorator {
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.2;
    public ViajeZonaPeligrosa(ViajeAbstract viaje) {
        super(viaje);
    }

    @Override
    public double getpasajeros() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public double getkm() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public void getViaje() {
        // TODO Implement this method
    }

    @Override
    public double getCosto() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public void getCalificacionDelChofer() {
        // TODO Implement this method
    }

    @Override
    public double getDistanciaRecorrida() {
        // TODO Implement this method
        return 0.0;
    }
    @Override
    public double getCostoDecorado() {
        
        return (this.costo_base * aumento_por_pasajero)*pedido.getCantPasajeros() + ((this.costo_base *aumento_por_km) * this.getkm());
    }
}