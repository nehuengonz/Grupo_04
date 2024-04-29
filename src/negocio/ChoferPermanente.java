package negocio;

public class ChoferPermanente extends ChoferEmpleado{

    protected double plus_X_antiguedad;// en decimal de 1 a 100
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
        //sueldo bruto con hijos y antiguedad
        double ans=this.sueldo_basico;
        double ans_antiguedad=ans * (1+ this.plus_X_antiguedad /100);//ejemplo ans= ans* (1+20% /100) -> ans *(1+0.2)
        double ans_hijos=ans* (1+this.plus_X_hijos /100);

        return ans_antiguedad +ans_hijos;
    }

    @Override
    public double getSueldoNeto() {
        // sueldo bruto - aportes jubilatiorios
        return this.getSueldoBruto() * (1-this.aportes/100);
    }
}
