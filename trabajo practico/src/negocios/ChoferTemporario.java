package negocios;

public class ChoferTemporario extends Chofer{
    protected double sueldo_basico;
    protected double aportes;
    protected double plus_X_cantidad_viajes;

    public ChoferTemporario(double sueldo_basico, double aportes, double plus_X_cantidad_viajes) {
        super();
        this.sueldo_basico = sueldo_basico;
        this.aportes = aportes;
        this.plus_X_cantidad_viajes = plus_X_cantidad_viajes;
    }

    public ChoferTemporario() {
        super();
    }

    @Override
    public double getSueldoBruto() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public double getSueldoNeto() {
        // TODO Implement this method
        return 0.0;
    }
}
