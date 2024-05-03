package negocio;

public abstract class Chofer {
<<<<<<< HEAD
  protected String dni;
  protected String nombre;
  protected boolean ocupado;
=======
    protected String  dni;
    protected String nombre;
    protected boolean disponible=true;
>>>>>>> main

  public Chofer(String dni, String nombre) {
    super();
    this.dni = dni;
    this.nombre = nombre;
  }

  public Chofer() { super(); }

  public void setDni(String dni) { this.dni = dni; }

  public String getDni() { return dni; }

  public void setNombre(String nombre) { this.nombre = nombre; }

  public String getNombre() { return nombre; }
  public boolean getOcupado() { return ocupado; }
  public void setOcupado(boolean value) { ocupado = value; }

  public abstract double getSueldoBruto();
  public abstract double getSueldoNeto();

<<<<<<< HEAD
  @Override
  public String toString() {
    return "Chofer [dni=" + dni + ", nombre=" + nombre + "]";
  }
=======
    public abstract double getSueldoBruto();
    public abstract double getSueldoNeto();

	@Override
	public String toString() {
		return "Chofer [dni=" + dni + ", nombre=" + nombre + "]";
	}

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
>>>>>>> main
}
