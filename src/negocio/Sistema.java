package negocio;

import excepciones.PedidoInvalidoException;
import excepciones.SinVehiculosDisponiblesException;
import java.util.ArrayList;

/*
 * @invariant choferes, vehiculos, clientes y viajes siempre distintos de null.
 */
public class Sistema {

  private static Sistema instance;
  private ArrayList<Chofer> choferes = new ArrayList<>();
  private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
  private ArrayList<Cliente> clientes = new ArrayList<>();
  private ArrayList<ViajeAbstract> viajes = new ArrayList<>();

  private Sistema() {
    // privado por el patron Singleton
  }

  /*
   * Siempre retorna la misma instancia o crea una si todavía no hay.
   * @invariant instancia devuelta.
   */
  public static Sistema getInstance() {
    if (instance == null) {
      instance = new Sistema(); // inizializa el sistema
    }
    return instance;
  }
  // getters
  public ArrayList<Chofer> getChoferes() { return choferes; }

  public ArrayList<Vehiculo> getVehiculos() { return vehiculos; }

  public ArrayList<Cliente> getClientes() { return clientes; }

  public ArrayList<ViajeAbstract> getViajes() { return viajes; }

  // metodos del sistema
  /*
   * Lanza PedidoInvalidoException si no es posible asignar un vehículo (aunque
   * haya vehículos de todos los tipos). Por ejemplo si el pedido tiene más de
   * 10 pasajeros (ningún vehículo puede llevar más de 10). Lanza
   * SinVehiculosDisponiblesException si la razón de rechazar el pedido es que
   * no hay vehículos del tipo necesario para satisfacer el pedido.
   */
  public void procesarPedido(Pedido pedido)
      throws PedidoInvalidoException, SinVehiculosDisponiblesException {
    if (!pedidoValido(pedido))
      throw new PedidoInvalidoException();
    if (pedido.getCantPasajeros() > 4) {
      Combi combi = getCombiDisponible();
      if (combi == null)
        throw new SinVehiculosDisponiblesException();
    }
  }
  private boolean pedidoValido(Pedido pedido) {
    if (pedido.getCantPasajeros() > 10)
      return false;
    if (pedido.getCantPasajeros() > 4 && pedido.isSPF())
      return false;
    return true;
  }
  /*
   * Si encuentra una combi disponible la retorna.
   * Si no devuelve null.
   */
  private Combi getCombiDisponible() {
    for (Vehiculo v : vehiculos) {
      if (v.isDisponible() && v instanceof Combi)
        return (Combi)v;
    }
    return null;
  }
  public void agregarVehiculo(Vehiculo vehiculo) { vehiculos.add(vehiculo); }
  public void sacaVehiculo(Vehiculo vehiculo) { vehiculos.remove(vehiculo); }
  public void agregaChofer(Chofer chofer) { choferes.add(chofer); }
  public void sacaChofer(Chofer chofer) { choferes.remove(chofer); }
  public void agregaCliente(Cliente cliente) { clientes.add(cliente); }
  public void sacaCliente(Cliente cliente) { clientes.remove(cliente); }

  public void agregaViaje(ViajeAbstract viaje) { viajes.add(viaje); }
  public void sacaViaje(ViajeAbstract viaje) { viajes.remove(viaje); }

  // devuelve un vehiculo disponible y lo pone como nodisponible, se usa en el
  // factoryvehiculos.java
  public Vehiculo vehiculoDisponible(String clase) {
    Vehiculo aux = null;
    for (Vehiculo act : vehiculos) {
      if (act.getClass().getName() == clase && act.disponible == true) {
        aux = act;
        aux.disponible = false;
      }
    }
    return aux;
  }

  public String toStringChoferes() {
    return "Sistema [choferes=" + choferes + "]";
  }

  public String toStringVehiculos() {
    return "Sistema [vehiculos=" + vehiculos + "]";
  }
}
