package negocio;

public class ChoferTemporario extends ChoferEmpleado{

    protected double plus_X_cantidad_viajes;
    protected double cant_viajes;
    
    public ChoferTemporario(double sueldo_basico, double aportes, double plus_X_cantidad_viajes) {
        super();
        this.sueldo_basico = sueldo_basico;
        this.aportes = aportes;
        this.plus_X_cantidad_viajes = plus_X_cantidad_viajes;
        this.cant_viajes=0;
    }

    public ChoferTemporario() {
        super();
    }
    @Override
    public double getSueldoBruto() {
        // TODO Implement this method
        return  sueldo_basico*this.plus_X_cantidad_viajes*cant_viajes;
    }
    @Override
    public double getSueldoNeto() {
        // TODO Implement this method
        return sueldo_basico*this.plus_X_cantidad_viajes*cant_viajes*(1-aportes)*cant_viajes;
    }
}