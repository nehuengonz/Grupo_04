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

    public static ViajeAbstract fromZona(Zona zona, Pedido pedido) throws Exception {
        switch(zona) {
            case ESTANDAR:
                return new ViajeEstandar(pedido);
            case SIN_ASFALTAR:
                return new ViajeCalleSinAsfaltar(pedido);
            case PELIGROSA:
                return new ViajeZonaPeligrosa(pedido);
            default: throw new Exception("Error: zona inesperada.");
        }
    }
}
