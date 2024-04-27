package negocio;

public abstract class Usuario {
  protected String nombreUs;
  protected String contrasenia;
  protected String nombreReal;

  public Usuario(String nombreUs, String contrasenia, String nombreReal) {
    this.nombreUs = nombreUs;
    this.contrasenia = contrasenia;
    this.nombreReal = nombreReal;
  }

  public Usuario() { super(); }

  public String getNombreUs() { return nombreUs; }

  public String getContrasenia() { return contrasenia; }

  public String getNombreReal() { return nombreReal; }
}
