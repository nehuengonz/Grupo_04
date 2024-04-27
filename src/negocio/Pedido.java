package negocio;

public class Pedido {
  private Zona zona;
  private boolean SPF; // service pet friendly
  private boolean usaBaul;
  private String fecha;
  private Integer cantPasajeros;
  private Cliente cliente;

  public Pedido(Zona zona, boolean SPF, boolean usaBaul, String fecha,
                Integer cantPasajeros) {
    super();
    this.zona = zona;
    this.SPF = SPF;
    this.usaBaul = usaBaul;
    this.fecha = fecha;
    this.cantPasajeros = cantPasajeros;
  }

  public Zona getZona() { return zona; }

  public boolean isSPF() { return SPF; }

  public boolean getUsaBaul() { return usaBaul; }

  public String getFecha() { return fecha; }

  public Integer getCantPasajeros() { return cantPasajeros; }

  public Cliente getCliente() { return cliente; }
}
