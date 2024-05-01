package negocio;

public class ViajeCalleSinAsfaltar extends ViajeAbstract{
    private static final double aumento_por_pasajero=0.2;
    private static final double aumento_por_km=0.15;
    public ViajeCalleSinAsfaltar(Iviaje viaje) {
        super.setViaje(viaje);
    }

    @Override
    public double getpasajeros() {
        
        return 0.0;
    }

    @Override
    public double getkm() {
        // TODO Implement this method
        return 0.0;
    }


    //obtiene el costo del decorado anterior-> viaje abstracto y lo multiplica por el aumento de la calle sin asfaltar
    public double getCosto(){
        return  (this.getviaje().getCosto())*
        (this.pedido.getCantPasajeros()*aumento_por_pasajero)*
        (this.viaje.getkm()*aumento_por_km);

    }
    @Override
    public double getCostoDecorado() {
        
        return (this.costo_base * aumento_por_pasajero)*pedido.getCantPasajeros() + ((this.costo_base *aumento_por_km) * this.getkm());
    }

    @Override
    public void getCalificacionDelChofer() {
        // TODO Implement this method
    }

    @Override
    public double getDistanciaRecorrida() {
        // TODO Implement this method
        return 0.0;
    }

}