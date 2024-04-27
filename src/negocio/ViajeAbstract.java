package negocio;

public abstract class ViajeAbstract implements Iviaje{
    protected Pedido pedido;
    protected Chofer chofer;
    protected Vehiculo vehiculo;
    //crear clases viaje a zona peligrosa/viaje calle sin asfaltar/viaje estandar
    public ViajeAbstract() {
        super();
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}