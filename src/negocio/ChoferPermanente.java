package negocio;

public class ChoferPermanente extends ChoferEmpleado{

    protected double plus_X_antiguedad;
    protected double plus_X_hijos;
    protected String fecha_ingreso;


    public ChoferPermanente(double plus_X_antiguedad, double plus_X_hijos, String fecha_ingreso) {
        super();
        this.plus_X_antiguedad = plus_X_antiguedad;
        this.plus_X_hijos = plus_X_hijos;
        this.fecha_ingreso = fecha_ingreso;
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
