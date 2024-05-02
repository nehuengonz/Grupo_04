package negocio;

public class ViajeEstandar extends ViajeAbstract {
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.1;
    
    public ViajeEstandar(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
        super(pedido, chofer, vehiculo);
        //TODO Auto-generated constructor stub
    }
    @Override
    public double getpasajeros() {
        // TODO Implement this method
        return this.pedido.getCantPasajeros();
    }

    @Override
    public double getkm() {
        // TODO Implement this method
        return super.getkm();
    }


    @Override
    public double getCosto(){
        return  (this.getViaje().getCosto())*
        (this.pedido.getCantPasajeros()*aumento_por_pasajero)*
        (this.viaje.getkm()*aumento_por_km);
    }

    @Override
    public void getCalificacionDelChofer() {
        // TODO Implement this method
    }


    /*  
    @Override
    public double getCostoDecorado() {
        return (this.costo_base * aumento_por_pasajero)*pedido.getCantPasajeros() + ((this.costo_base *aumento_por_km) * this.getkm());
    }
    */
}