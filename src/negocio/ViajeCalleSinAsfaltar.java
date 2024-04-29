package negocio;

public class ViajeCalleSinAsfaltar extends ViajeAbstract{
    private static final double aumento_por_pasajero=0.2;
    private static final double aumento_por_km=0.15;
    public ViajeCalleSinAsfaltar() {
        super();
    }

    @Override
    public double getpasajeros() {
        
        return this.getpasajeros();
    }

    @Override
    public double getkm() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public void getViaje() {
       
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