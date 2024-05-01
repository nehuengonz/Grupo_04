package negocio;

public class ViajeEstandar extends ViajeAbstract {
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.1;
    public ViajeEstandar(Pedido pedido) {
        super(pedido);
    }

    @Override
    public double getCantPasajeros() {
        return pedido.getCantPasajeros();
    }

    @Override
    public double getDistanciaRecorridaEnKm() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public double getCosto() {
        return costoBase * (1 + 0.1 * getCantPasajeros() + 0.1 * getDistanciaRecorridaEnKm());
    }
}