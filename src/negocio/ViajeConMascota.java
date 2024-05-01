package negocio;

public class ViajeConMascota extends ViajeDecorator {

    public ViajeConMascota(ViajeAbstract viaje) {
        super(viaje);
    }

    @Override
    public double getCantPasajeros() {
        return 0;
    }

    @Override
    public double getDistanciaRecorridaEnKm() {
        return 0;
    }

    @Override
    public double getCosto() {
        return viajeWrapee.getCosto() + costoBase * (0.1 * getCantPasajeros() + 0.2 * getDistanciaRecorridaEnKm());
    }
}
