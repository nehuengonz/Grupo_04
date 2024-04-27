package negocio;

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

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double getSueldoBruto();
    public abstract double getSueldoNeto();

	@Override
	public String toString() {
		return "Chofer [dni=" + dni + ", nombre=" + nombre + "]";
	}
    
}
