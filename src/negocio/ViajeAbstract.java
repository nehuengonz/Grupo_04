package negocio;

public abstract class ViajeAbstract implements Iviaje{
    protected double costo_base=1000; 
    


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
        return getCostoBaul()+getCostoMascota() + getCostoDecorado();
    }
    public double getCostoBaul(){
        double res=costo_base;
        double aumento_km=1.05;
        double aumento_pasajero=1.1;
        if (pedido.getUsaBaul() ==true)
        {
            res*=(aumento_pasajero *pedido.getCantPasajeros())+(aumento_km * this.getkm());
        }
        return res; 
    }
    public double getCostoMascota(){
        double res=costo_base;
        double aumento_km=1.2;
        double aumento_pasajero=1.1;
        if (pedido.isSPF() ==true){
            res *= (aumento_pasajero *pedido.getCantPasajeros())+(aumento_km * this.getkm());
        }
        return res;
    }
    public abstract double getCostoDecorado();
}