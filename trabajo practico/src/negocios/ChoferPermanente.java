package negocios;

public class ChoferPermanente extends Chofer{

    protected double sueldo_basico;
    protected double plus_X_antiguedad;
    protected double plus_X_hijos;
    protected double aportes;
    protected String fecha_ingreso;
    public ChoferPermanente(String dni, String nombre) {
        // TODO Implement this method
        super(dni, nombre);
    }
    
    public ChoferPermanente() {
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
