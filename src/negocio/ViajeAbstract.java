package negocio;

public abstract class ViajeAbstract implements Iviaje{
    protected static double costo_base=1000; 


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
    public double getValorBase(){
        return costo_base;
    }
    //devuelve el costo aumentado por mascota y/o baul
    public double getCosto(){
        double ans=costo_base;
        if (pedido.getUsaBaul() ==true)
        {
            ans*=(1.1 *pedido.getCantPasajeros())+ (1.05* this.getkm());
        }
        if (pedido.isSPF() ==true){
            ans *= (1.1 *pedido.getCantPasajeros())+(1.2 * this.getkm());
        }
        return ans + getCostoDecorado();
    }
    public abstract double getCostoDecorado();
}