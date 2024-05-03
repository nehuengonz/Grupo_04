package negocio;

import excepciones.*;

import java.util.ArrayList;
import java.util.List;

/*
 * @invariant choferes, vehiculos, clientes y viajes siempre distintos de null.
 */
public class Sistema {

  private static Sistema instance;
  private ArrayList<Chofer> choferes = new ArrayList<>();
  private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
  private ArrayList<Cliente> clientes = new ArrayList<>();
  private ArrayList<Iviaje> viajes = new ArrayList<>();

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

  public ArrayList<Iviaje> getViajes() { return viajes; }

  // metodos del sistema
  /*
   * Lanza PedidoInvalidoException si no es posible asignar un vehículo (aunque
   * haya vehículos de todos los tipos). Por ejemplo si el pedido tiene más de
   * 10 pasajeros (ningún vehículo puede llevar más de 10). Lanza
   * SinVehiculosDisponiblesException si la razón de rechazar el pedido es que
   * no hay vehículos del tipo necesario para satisfacer el pedido. Si hay
   * vehículos disponibles se asigna al viaje y pasa a estado 'con vehiculo'.
   * Finalmente se asigna un chofer al viaje. Si no hay choferes disponibles,
   * lanza SinChoferDisponibleException. En cambio, si hay un chofer disponible,
   * se asigna y el viaje pasa a 'iniciado'.
   */
  public void procesarPedido(Pedido pedido)
      throws Exception {
    Combi combi = getCombiDisponible();
    Automovil automovil = getAutomovilDisponible();
    Moto moto = getMotoDisponible();
    Vehiculo vehiculo = vehiculoConMayorPrioridad(pedido, moto, automovil, combi);
    if(vehiculo == null) {
      throw new PedidoInvalidoException();
    }
    vehiculo.setDisponible(false);

   Chofer chofer = getChoferDisponible();
   if(chofer == null) {
     throw new SinChoferDisponibleException();
   }

  Iviaje viaje = FactoryViaje.getViaje(pedido, vehiculo, chofer);
   viajes.add(viaje);
  }

  private Vehiculo vehiculoConMayorPrioridad(Pedido pedido, Moto moto, Automovil automovil, Combi combi) throws SinVehiculosDisponiblesException {
    List<Vehiculo> vehiculos = new ArrayList<>();
    if(moto != null) vehiculos.add(moto);
    if(automovil != null) vehiculos.add(automovil);
    if(combi != null) vehiculos.add(combi);
    if(vehiculos.isEmpty()) {
      throw new SinVehiculosDisponiblesException();
    }
    Integer mayorPrioridad = -1;
    Vehiculo vehiculoMayorPrioridad = null;
    for(Vehiculo v : vehiculos) {
      Integer prioridad = v.getPrioridad(pedido);
      if(prioridad != null && mayorPrioridad < prioridad) {
        mayorPrioridad = prioridad;
        vehiculoMayorPrioridad = v;
      }
    }
    return vehiculoMayorPrioridad;
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
  private Automovil getAutomovilDisponible() {
    for (Vehiculo v : vehiculos) {
      if (v.isDisponible() && v instanceof Automovil)
        return (Automovil)v;
    }
    return null;
  }
  private Moto getMotoDisponible() {
    for (Vehiculo v : vehiculos) {
      if (v.isDisponible() && v instanceof Moto) 
        return (Moto)v;
    }
    return null;
  }
  private Chofer getChoferDisponible() {
    for (Chofer c : choferes) {
      if (!c.getOcupado())
        return c;
    }
    return null;
  }

  public void agregarVehiculo(Vehiculo vehiculo) { vehiculos.add(vehiculo); }
  public void sacaVehiculo(Vehiculo vehiculo) { vehiculos.remove(vehiculo); }
  public void agregaChofer(Chofer chofer) { choferes.add(chofer); }
  public void sacaChofer(Chofer chofer) { choferes.remove(chofer); }
  public void agregaCliente(Cliente cliente) { clientes.add(cliente); }
  public void sacaCliente(Cliente cliente) { clientes.remove(cliente); }

  public void agregaViaje(Iviaje viaje) { viajes.add(viaje); }
  public void sacaViaje(Iviaje viaje) { viajes.remove(viaje); }

  public String toStringChoferes() {
    return "Sistema [choferes=" + choferes + "]";
  }

  public String toStringVehiculos() {
    return "Sistema [vehiculos=" + vehiculos + "]";
  }

	@Override
	public String toString() {
		return "Sistema [viajes=" + viajes + "]";
	}
  


}
