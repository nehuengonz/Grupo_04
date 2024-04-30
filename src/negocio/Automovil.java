package negocio;

public class Automovil extends Vehiculo {
  private static final double cant_max_pasajeros = 4;

  public Automovil(String nropatente) {
    super(nropatente, cant_max_pasajeros, true, true);
  }

  protected boolean verificarCantPasajeros(Integer cantPasajeros) {
    return cantPasajeros <= 4;
  }
  protected boolean verificarBaul(boolean usaBaul) { return true; }
  protected boolean verificarPF(boolean PF) { return true; }
  
  protected Integer calculoPrioridad(Pedido pedido) {
    if (pedido.getUsaBaul()) {
      return 40 * pedido.getCantPasajeros();
    }
    return 30 * pedido.getCantPasajeros();
  }

  @Override
  public String toString() {
    return "Automovil [toString()=" + super.toString() + "]";
  }
}
