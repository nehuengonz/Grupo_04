package negocio;

public class ViajeConMascota extends ViajeDecorator {

    public ViajeConMascota(ViajeAbstract viaje) {
        super(viaje);
    }

    @Override
    public double getCostoDecorado() {
        return 0;
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
    public void getViaje() {

    }

    @Override
    public void getCalificacionDelChofer() {

    }

    @Override
    public double getDistanciaRecorrida() {
        return 0;
    }
}
