package negocio;

public class ViajeConBaul extends ViajeDecorator {

    public ViajeConBaul(ViajeAbstract viaje) {
        super(viaje);
    }

    @Override
    public double getCantPasajeros() {
        return viajeWrapee.getCantPasajeros();
    }

    @Override
    public double getDistanciaRecorridaEnKm() {
        return viajeWrapee.getDistanciaRecorridaEnKm();
    }

    @Override
    public double getCosto() {
        return viajeWrapee.getCosto() + costoBase * (0.1 * getCantPasajeros() + 0.05 * getDistanciaRecorridaEnKm());
    }
}
