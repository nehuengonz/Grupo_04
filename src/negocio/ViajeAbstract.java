package negocio;

public abstract class ViajeAbstract implements Iviaje {
    protected double costoBase = 1000;

    protected Pedido pedido;
    protected Chofer chofer;

    /*
     * El pedido se inicializa en el constructor y después no se vuelve a modificar.
     */
    public ViajeAbstract(Pedido pedido) {
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
}
