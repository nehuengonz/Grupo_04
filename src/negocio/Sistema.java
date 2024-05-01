package negocio;

import excepciones.PedidoInvalidoException;
import excepciones.SinVehiculosDisponiblesException;
import excepciones.sinchoferesdisponiblesException;

import java.util.ArrayList;

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
   * no hay vehículos del tipo necesario para satisfacer el pedido.
   */
  public void procesarPedido(Pedido pedido)
      throws PedidoInvalidoException, SinVehiculosDisponiblesException, sinchoferesdisponiblesException {
    if (!pedidoValido(pedido))
      throw new PedidoInvalidoException();
    // TODO: crear viaje en estado "solicitado"
    Vehiculo vehiculo = getVehiculoDisponible(pedido);
    Chofer chofer=getChoferDisponible();
  
    ViajeAbstract viaje=null;
    Iviaje viajeconcreto=viaje.getviaje(pedido, chofer, vehiculo);

    viajes.add(viajeconcreto);

    
      
   

    if (chofer ==null)
      throw new sinchoferesdisponiblesException();
    if (vehiculo == null)
      throw new SinVehiculosDisponiblesException();
    // TODO: Asignarle vehiculo al viaje (ahora en estado "con vehiculo")
  }

  //contemplar tambien si la zona del pedido es valida
  private boolean pedidoValido(Pedido pedido) {
    if (pedido.getCantPasajeros() > 10)
      return false;
    if (pedido.getCantPasajeros() > 4 && pedido.isSPF())
      return false;
    return true;
  }

  private Vehiculo getVehiculoDisponible(Pedido pedido) {
    if (pedido.getCantPasajeros() > 4) {
      return getCombiDisponible();
    }
    if (pedido.getCantPasajeros() > 1 || pedido.isSPF() ||
        pedido.getUsaBaul()) {
      return getAutomovilDisponible();
    }
    return getMotoDisponible();
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
  public void agregarVehiculo(Vehiculo vehiculo) { vehiculos.add(vehiculo); }
  public void sacaVehiculo(Vehiculo vehiculo) { vehiculos.remove(vehiculo); }
  public void agregaChofer(Chofer chofer) { choferes.add(chofer); }
  public void sacaChofer(Chofer chofer) { choferes.remove(chofer); }
  public void agregaCliente(Cliente cliente) { clientes.add(cliente); }
  public void sacaCliente(Cliente cliente) { clientes.remove(cliente); }

  public void agregaViaje(Iviaje viaje) { viajes.add(viaje); }
  public void sacaViaje(Iviaje viaje) { viajes.remove(viaje); }

  // devuelve un vehiculo disponible y lo pone como nodisponible, se usa en el
  // factoryvehiculos.java
  

  public Vehiculo GetVehiculoDisponible(double cantPasajeros,boolean PF,boolean baul) {
    if (cantPasajeros == 1 && PF==false  && baul==false) {
        return vehiculoDisponible("Moto");
      } else if (cantPasajeros <= 4) {
        return vehiculoDisponible("Automovil");
      } else if(PF==false){
        return vehiculoDisponible("Combi");
      }else{
        return null;
      } 
    }
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
  //devuelve el primer chofer disponible
  public Chofer getChoferDisponible(){
    Chofer aux=null;
    for (Chofer act:choferes){
      if(act.isDisponible()== true)
        aux=act;
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
