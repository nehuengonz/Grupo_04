package negocio;

import java.util.Random;

public abstract class ViajeAbstract implements Iviaje {
    protected double costo_base=1000; 
    protected Iviaje viaje;

    protected Pedido pedido;
    protected Chofer chofer;
    protected Vehiculo vehiculo;
    
    public ViajeAbstract(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
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
    //aca el costo 
    public double getCosto(){
        return costo_base;
    }
    public double getCostoBaul(){
        double res=0;
        double aumento_km=1.05;
        double aumento_pasajero=1.1;
        if (pedido.getUsaBaul() ==true)
        {
            res=this.getCosto()*(aumento_pasajero *pedido.getCantPasajeros())+(aumento_km * this.getkm());
        }
        return res; 
    }
    public double getCostoMascota(){
        double res=0;
        double aumento_km=1.2;
        double aumento_pasajero=1.1;
        if (pedido.isSPF() ==true){
            res = this.getCosto()*(aumento_pasajero *pedido.getCantPasajeros())+(aumento_km * this.getkm());
        }
        return res;
    }

    public double getCosto_base() {
        return costo_base;
    }

    public void setCosto_base(double costo_base) {
        this.costo_base = costo_base;
    }


  
    public Iviaje getViaje(){
        return this.viaje;
    }

    public void setViaje(Iviaje viaje) {
        this.viaje = viaje;
    }
    //get kilometros implemented numero aleatorio de 0 a 40 
    public double getkm(){
        Random random = new Random();
        return random.nextInt(40);
    }

	@Override
	public String toString() {
		return "ViajeAbstract [costo_base=" + costo_base + ", viaje=" + viaje + ", pedido=" + pedido + ", chofer="
				+ chofer + ", vehiculo=" + vehiculo + "]";
	}


  

}