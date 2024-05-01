package negocio;

public class ViajeCalleSinAsfaltar extends ViajeAbstract {
    private static final double aumento_por_pasajero=0.2;
    private static final double aumento_por_km=0.15;
    public ViajeCalleSinAsfaltar(Pedido pedido) {
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
        return costoBase * (1 + 0.2 * pedido.getCantPasajeros() + 0.15 * getDistanciaRecorridaEnKm());
    }
}