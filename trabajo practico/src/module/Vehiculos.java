package module;

public abstract class Vehiculos {
    protected String nropatente;
    protected double cant_max_pasajeros;
    protected boolean PF;
    protected boolean baul;


    public Vehiculos(String nropatente, double cant_max_pasajeros, boolean PF, boolean baul) {
        super();
        this.nropatente = nropatente;
        this.cant_max_pasajeros = cant_max_pasajeros;
        this.PF = PF;
        this.baul = baul;
    }
    public Integer getPrioridad(Pedido pedido){
        return 1;
    }
    public Vehiculos() {
        super();
    }
}
