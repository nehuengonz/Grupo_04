package negocio;

import java.util.Random;

public abstract class ViajeAbstract implements IViaje {
    protected double costoBase = 1000;

    protected Pedido pedido;
    protected Chofer chofer;
    protected Vehiculo vehiculo;

    /*
     * El pedido se inicializa en el constructor y después no se vuelve a modificar.
     */
    public ViajeAbstract(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
        this.pedido = pedido;
        this.chofer = chofer;
        this.vehiculo = vehiculo;
    }

    //crear clases viaje a zona peligrosa/viaje calle sin asfaltar/viaje estandar
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
        chofer.setOcupado(true);
    }

    public Chofer getChofer() {
        return chofer;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getDistanciaRecorridaEnKm(){
        Random random = new Random();
        return random.nextInt(40);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        pedido = (Pedido)pedido.clone();
        return super.clone();
    }

    @Override
    public String toString() {
        return "ViajeAbstract [costo_base=" + costoBase + ", pedido=" + pedido + ", chofer="
                + chofer + ", vehiculo=" + vehiculo + "]";
    }
}
