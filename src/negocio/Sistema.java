package negocio;

import excepciones.*;

import java.util.ArrayList;
import java.util.List;

/*
 * @invariant choferes, vehiculos, clientes y viajes siempre distintos de null.
 */
/**
 * clase que se encarga de todas las funcionalidades de la empresa, 
 * ademas e almacenar la informacion de todos los Choferes,vehiculos,clientes y viajes
 * es la clase principal del proyecto
 */
public class Sistema {

  private static Sistema instance;
  private ArrayList<Chofer> choferes = new ArrayList<>();
  private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
  private ArrayList<Cliente> clientes = new ArrayList<>();
  private ArrayList<IViaje> viajes = new ArrayList<>();

  private Sistema() {
    // privado por el patron Singleton
  }

  /**
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

  public ArrayList<IViaje> getViajes() { return viajes; }

  // metodos del sistema
  /**
   * Lanza PedidoInvalidoException si no es posible asignar un vehículo (aunque
   * haya vehículos de todos los tipos). Por ejemplo si el pedido tiene más de
   * 10 pasajeros (ningún vehículo puede llevar más de 10). Lanza
   * SinVehiculosDisponiblesException si la razón de rechazar el pedido es que
   * no hay vehículos del tipo necesario para satisfacer el pedido. Si hay
   * vehículos disponibles se asigna al viaje y pasa a estado 'con vehiculo'.
   * Finalmente se asigna un chofer al viaje. Si no hay choferes disponibles,
   * lanza SinChoferDisponibleException. En cambio, si hay un chofer disponible,
   * se asigna y el viaje pasa a 'iniciado'.
   * @param pedido
   * @throws Exception
   */
  public void procesarPedido(Pedido pedido)
      throws PedidoInvalidoException, SinVehiculosDisponiblesException, SinChoferDisponibleException {
    Combi combi = getCombiDisponible();
    Automovil automovil = getAutomovilDisponible();
    Moto moto = getMotoDisponible();
    Vehiculo vehiculo = vehiculoConMayorPrioridad(pedido, moto, automovil, combi);
    if(vehiculo == null) {
      if(!pedidoValido(pedido))
        throw new PedidoInvalidoException();
      throw new SinVehiculosDisponiblesException();
    }
    vehiculo.setDisponible(false);

    Chofer chofer = getChoferDisponible();
    if(chofer == null) {
      throw new SinChoferDisponibleException();
    }

    IViaje viaje = FactoryViaje.getViaje(pedido, vehiculo, chofer);
    viajes.add(viaje);
  }

  private boolean pedidoValido(Pedido pedido) {
    if(pedido.getCantPasajeros() > 10)
      return false;
    return pedido.getCantPasajeros() <= 4 || !pedido.isSPF();
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

  public void procesarPago(double valor) {

  }

  public void guardarCalificacionChofer() {}

  public void registrarViajeFinalizado(ViajeAbstract viaje) {
    viajes.add(viaje);
    choferes.remove(viaje.getChofer());
    choferes.add(viaje.getChofer());
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

  // Altas y bajas
  public void agregarVehiculo(Vehiculo vehiculo) { vehiculos.add(vehiculo); }
  public void sacaVehiculo(Vehiculo vehiculo) { vehiculos.remove(vehiculo); }
  public void agregaChofer(Chofer chofer) { choferes.add(chofer); }
  public void sacaChofer(Chofer chofer) { choferes.remove(chofer); }
  public void agregaCliente(Cliente cliente) { clientes.add(cliente); }
  public void sacaCliente(Cliente cliente) { clientes.remove(cliente); }
  public void agregaViaje(IViaje viaje) { viajes.add(viaje); }
  public void sacaViaje(IViaje viaje) { viajes.remove(viaje); }

  public ArrayList<ViajeAbstract> listadoViajes() {
    ArrayList<ViajeAbstract> clonViajes = new ArrayList<>();
    for(IViaje viaje : viajes)
      clonViajes.add((ViajeAbstract)viaje);
    quicksort(clonViajes, 0, clonViajes.size() - 1);
    return clonViajes;
  }
  private void quicksort(ArrayList<ViajeAbstract> array, int begin, int end) {
    if(begin >= end) return;

    int partitionIndex = partition(array, begin, end);

    quicksort(array, begin, partitionIndex-1);
    quicksort(array, partitionIndex+1, end);
  }
  private int partition(ArrayList<ViajeAbstract> array, int begin, int end) {
    ViajeAbstract pivot = array.get(end);
    int i = begin-1;

    for(int j = begin; j < end; j++) {
      if(array.get(j).compareTo(pivot) > 0) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i+1, end);
    return i+1;
  }
  private void swap(ArrayList<ViajeAbstract> array, int i, int j) {
    ViajeAbstract temp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, temp);
  }

  public double getSueldoBrutoChofer(String dni) {
	  double ans=0;
	  for(Chofer chof:choferes) {
		  if(chof.getDni().equalsIgnoreCase(dni)) {
			  ans=chof.getSueldoBruto();
		  }
	  }
	  return ans;
  }
  public double getSueldoNetoChofer(String dni) {
	  double ans=0;
	  for(Chofer chof:choferes) {
		  if(chof.getDni().contains(dni)) {
			  ans=chof.getSueldoNeto();
		  }
	  }
	  return ans;
  }
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
