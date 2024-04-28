package negocio;

/*
 * @invariant zona, SPF, usaBaul, cantPasajeros.
 */
class Viaje {
  private Pedido pedido;
  private Chofer chofer;
  private Vehiculo vehiculo;
  private double distanciaRecorrida;
  private double costo;

  /*
   * Con el constructor se inicializa pedido. chofer y vehiculo son null hasta
   * que se les asigne un valor distinto de null por medio de los setters.
   * distanciaRecorrida y costo son null inicialmente.
   */
  public Viaje(Pedido pedido) { this.pedido = pedido; }

  public void setPedido(Pedido pedido) { this.pedido = pedido; }

  public Pedido getPedido() { return pedido; }

  public void setChofer(Chofer chofer) {
    this.chofer = chofer;
    this.chofer.setOcupado(true);
  }

  public Chofer getChofer() { return chofer; }

  /*
   * El vehiculo asignado pasa a no estar disponible (se asigna false a ese
   * atributo).
   */
  public void setVehiculo(Vehiculo vehiculo) {
    this.vehiculo = vehiculo;
    this.vehiculo.setDisponible(false);
  }

  public Vehiculo getVehiculo() { return vehiculo; }
}
