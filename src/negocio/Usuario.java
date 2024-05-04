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

  public String getNombreUs() { return nombreUs; }

  public String getContrasenia() { return contrasenia; }

  public String getNombreReal() { return nombreReal; }

  public void setNombreUs(String nombreUs) {
      this.nombreUs = nombreUs;
  }

  public void setContrasenia(String contrasenia) {
      this.contrasenia = contrasenia;
  }

  public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
}
}
