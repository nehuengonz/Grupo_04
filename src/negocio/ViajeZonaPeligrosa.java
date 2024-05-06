package negocio;

public class ViajeZonaPeligrosa extends ViajeAbstract {
    
    public ViajeZonaPeligrosa(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
        super(pedido, vehiculo, chofer);
    }
    @Override
    public double getCantPasajeros() {
        return pedido.getCantPasajeros();
    }

    @Override
    public double getDistanciaRecorridaEnKm() {
        // TODO Implement this method
        return this.pedido.getCantPasajeros();
    }

    @Override
    public double getCosto() {
        return costoBase * (1 + 0.1 * getCantPasajeros() + 0.2 * getDistanciaRecorridaEnKm());
    }
}