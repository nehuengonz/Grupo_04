package negocio;

public abstract class Vehiculo {
    protected String nropatente;
    protected double cant_max_pasajeros;
    protected boolean PF;
    protected boolean baul;
    protected boolean disponible;


    public Vehiculo(String nropatente, double cant_max_pasajeros, boolean PF, boolean baul) {
        super();
        this.nropatente = nropatente;
        this.cant_max_pasajeros = cant_max_pasajeros;
        this.PF = PF;
        this.baul = baul;
    }
    public Integer getPrioridad(Pedido pedido){
        return 1;
    }
    public Vehiculo() {
        super();
    }

    public void setNropatente(String nropatente) {
        this.nropatente = nropatente;
    }

    public String getNropatente() {
        return nropatente;
    }

    public void setCant_max_pasajeros(double cant_max_pasajeros) {
        this.cant_max_pasajeros = cant_max_pasajeros;
    }

    public double getCant_max_pasajeros() {
        return cant_max_pasajeros;
    }

    public void setPF(boolean PF) {
        this.PF = PF;
    }

    public boolean isPF() {
        return PF;
    }

    public void setBaul(boolean baul) {
        this.baul = baul;
    }

    public boolean isBaul() {
        return baul;
    }
	@Override
	public String toString() {
		return "Vehiculo [nropatente=" + nropatente + ", cant_pasajeros=" + cant_max_pasajeros + ", PF=" + PF + ", baul="
				+ baul + "]";
	}
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
	
   

    
}