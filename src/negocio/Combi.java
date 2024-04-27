package negocio;

public class Combi extends Vehiculo {
  private static final double cant_max_pasajeros = 10;

  public Combi(String nropatente) {
    super(nropatente, cant_max_pasajeros, false, true);
    /*
    if (cant_pasajeros>=cant_max_pasajeros) {
            throw new IllegalArgumentException("La cantidad de pasajeros excede
    el máximo permitido (10) para un autobús.");
    }
    */
    // faltan excepciones por baul o mascotas
  }

  protected boolean verificarCantPasajeros(Integer cantPasajeros) {
    return cantPasajeros <= 10;
  }
  protected boolean verificarBaul(boolean usaBaul) { return true; }
  protected boolean verificarPF(boolean PF) { return !PF; }
  protected Integer calculoPrioridad(Pedido pedido) {
    return 10 * pedido.getCantPasajeros() + (pedido.getUsaBaul() ? 100 : 0);
  }

  @Override
  public String toString() {
    return "Combi [toString()=" + super.toString() + "]";
  }
}
