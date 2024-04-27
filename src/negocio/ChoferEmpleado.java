package negocio;


public abstract class ChoferEmpleado extends Chofer{
    protected double sueldo_basico;
    protected double aportes;

    
    public ChoferEmpleado(double sueldo_basico, double aportes) {
        super();
        this.sueldo_basico = sueldo_basico;
        this.aportes = aportes;
    }


    public double getSueldo_basico() {
        return sueldo_basico;
    }

    public double getAportes() {
        return aportes;
    }

    public ChoferEmpleado() {
        super();
    }
}