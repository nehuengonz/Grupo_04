package negocio;

public abstract class ViajeDecorator extends ViajeAbstract {
    protected ViajeAbstract viajeWrapee;

    public ViajeDecorator(ViajeAbstract viaje) {
        super(viaje.pedido);
        viajeWrapee = viaje;
    }
}
