package negocio;

import java.util.Calendar;
import java.time.*;

public class ChoferPermanente extends ChoferEmpleado{
	
	//tiene que ser el mismo valor para todos los choferes permanentes osea que podria un atributo estatico
    protected static double plus_X_antiguedad=1.12;// en decimal de 1 a 100
    protected static double plus_X_hijos=1.06;
    protected LocalDate fecha_ingreso;


    public ChoferPermanente(LocalDate fecha_ingreso) {
        super();
        this.fecha_ingreso = fecha_ingreso;
    }

    public ChoferPermanente() {
        super();
        this.fecha_ingreso=LocalDate.now();
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
