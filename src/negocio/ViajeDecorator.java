package negocio;

public abstract class ViajeDecorator extends ViajeAbstract {
    public ViajeDecorator(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
        super(pedido, chofer, vehiculo);
        //TODO Auto-generated constructor stub
    }

    protected ViajeAbstract viajeWrapee;

    /* 
    public ViajeDecorator(ViajeAbstract viaje) {
        viajeWrapee = viaje;
    }
    */
}
