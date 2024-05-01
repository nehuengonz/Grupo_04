package negocio;

public class ViajeZonaPeligrosa extends ViajeAbstract {
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.2;
    public ViajeZonaPeligrosa(Pedido pedido) {
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
        return costoBase * (1 + 0.1 * getCantPasajeros() + 0.2 * getDistanciaRecorridaEnKm());
    }
}