package negocios;

public abstract class Chofer {
    protected String  dni;
    protected String nombre;


    public Chofer(String dni, String nombre) {
        super();
        this.dni = dni;
        this.nombre = nombre;
    }

    public Chofer() {
        super();
    }
    
    public abstract double getSueldoBruto();
    public abstract double getSueldoNeto();
    
}
