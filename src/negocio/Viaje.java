package negocio;

/*
 * @invariant zona, SPF, usaBaul, cantPasajeros.
 */
class Viaje {
  private Pedido pedido;
  private Chofer chofer;
  private Vehiculo vehiculo;
  private Zona zona;
  private boolean SPF;
  private boolean usaBaul;
  private Integer cantPasajeros;
  private double distanciaRecorrida;
  private double costo;

  /*
   * Con el constructor se inicializan pedido, zona, SPF, usaBaul y
   * cantPasajeros. chofer y vehiculo son null hasta que se les asigne un valor
   * distinto de null por medio de los setters.
   * distanciaRecorrida y costo son null inicialmente.
   */
  public Viaje(Pedido pedido, Zona zona, boolean SPF, boolean usaBaul,
               Integer cantPasajeros) {
    this.pedido = pedido;
    this.zona = zona;
    this.SPF = SPF;
    this.usaBaul = usaBaul;
    this.cantPasajeros = cantPasajeros;
  }

  public void setPedido(Pedido pedido) { this.pedido = pedido; }

  public Pedido getPedido() { return pedido; }

  public void setChofer(Chofer chofer) { this.chofer = chofer; }

  public Chofer getChofer() { return chofer; }

  public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

  public Vehiculo getVehiculo() { return vehiculo; }
}
