package negocio;

import excepciones.UsuarioRepetidoException;
import java.util.ArrayList;

/**
 * se encarga de la gention del sistema, tanto de los choferes,vehiculos,clientes y viajes
 * 
 */
public class Administrador extends Usuario {
  private Sistema sistema;

  public Administrador(String nombreUs, String contrasenia, String nombreReal) {
    super(nombreUs, contrasenia, nombreReal);
    sistema = Sistema.getInstance();
  }

    /**
     * @param username nombre de usuario del cliente
     * @param password contrasenia del cliente
     * @param realname nombre real del cliente
     * @throws UsuarioRepetidoException si se repite el nombre de usuario se lanza la excepcion
     */
    public void altasCliente(String username, String password, String realname)
      throws UsuarioRepetidoException {
    ArrayList<Cliente> clientes = sistema.getClientes();
    Cliente c = new Cliente(username, password, realname);
    try {
      for (Cliente cliAct : clientes) {
        if (cliAct.getNombreUs().equals(c.getNombreUs())) {
          throw new UsuarioRepetidoException();
        }
      }
      clientes.add(c);
    } catch (UsuarioRepetidoException e) {
      System.err.println("Este nombre de usuario ya existe");
    }
  }

    /**
     * @param dni dni del chofer dato necesario para buscarlo en la lista de choferes
     * @param nombre nombre del chofer
     * @param ganancia_viaje porcentaje de ganancia que recibira un chofer por viaje realizado
     */
    public void altasChoferContraatdo(String dni, String nombre, double ganancia_viaje) {
	  ChoferContratado chof=new ChoferContratado(dni,nombre,ganancia_viaje);
	  sistema.agregaChofer(chof);
      }

    /**
     * @param dni
     * @param nombre
     * @param sueldobasico sueldo basico del chofer
     * @param aportes   porcentaje descontado al sueldo bruto del chofer
     */
    public void altasChoferPermanente(String dni,String nombre,int sueldobasico,int aportes) {
	  ChoferPermanente chof=new ChoferPermanente(dni,nombre,sueldobasico,aportes);
	  sistema.agregaChofer(chof);
  }

    /**
     * @param dni
     * @param nombre
     * @param sueldo_basico
     * @param aportes
     */
    public void altasChoferTemporario(String dni, String nombre, double sueldo_basico, double aportes) {
	  ChoferTemporario chof=new ChoferTemporario(dni,nombre,sueldo_basico,aportes);
	  sistema.agregaChofer(chof);
  }
  // el tipo tiene que ser el nombre del vehiculo con la primera letra en
  // mayuscula

    /**
     * @param tipo
     * @param patente
     */
    public void altasVehiculo(String tipo, String patente) {
    sistema.agregarVehiculo(FactoryVehiculos.createVehiculo(tipo, patente));
  }
  //uso contains en modifica cliente

    /**
     * @Precondiciones:
     * nombreUs, newNombreUs, newPass, newName != null
     * @Postcondiciones:
     * nombreUs, contrasenia y nombreReal cambiados a los pasaedos por parámetro
     * @param nombreUs nombre de usuario actual
     * @param newNombreUs nuevo nombre de usuario
     * @param newPass nueva contrasenia
     * @param newName nuevo nombre
     */
    public void modificarCliente(String nombreUs, String newNombreUs, String newPass, String newName) {
      assert nombreUs != null && newNombreUs != null && newPass != null && newName != null;
      ArrayList<Cliente> clientes = sistema.getClientes();
      int i = 0;
      while(i < clientes.size() && !clientes.get(i).getNombreUs().equals(nombreUs))
        i++;
      if(i < clientes.size()) {
        Cliente act = clientes.get(i);
        act.setNombreUs(newNombreUs);
        act.setContrasenia(newPass);
        act.setNombreReal(newName);
      }
  }

    /**
     * @Precondiciones:
     * dni, newdni, nombre != null
     * @Postcondiciones:
     * dni y nombre de chofer cambiados a los pasados por parámetro.
     * @param dni
     * @param newdni
     * @param nombre
     */
  public void modificarChofer(String dni, String newdni,String nombre) {
      assert dni != null && newdni != null && nombre != null;
      ArrayList<Chofer> choferes = sistema.getChoferes();
      int i = 0;
      while( i < choferes.size() && !choferes.get(i).getDni().equals(dni))
        i++;
      if(i < choferes.size()) {
        Chofer act = choferes.get(i);
        act.setDni(newdni);
        act.setNombre(nombre);
      }
  }

    /**
     * @Precondiciones:
     * nropatente, newpatente != null
     * @Postcondiciones:
     * Si existe un vehiculo con ese nroPatente, nroPatente se cambia al pasado por parámetro.
     * Si no, no se cambia nada.
     * @param nropatente
     * @param newpatente
     */
  public void modificarVehiculo(String nropatente,String newpatente) {
      assert nropatente != null && newpatente != null;
      ArrayList<Vehiculo> vehiculos = sistema.getVehiculos();
      int i = 0;
      while(i < vehiculos.size() && !vehiculos.get(i).getNropatente().equals(nropatente))
          i++;
      if(i < vehiculos.size()) {
          Vehiculo act = vehiculos.get(i);
          act.setNropatente(newpatente);
      }
  }
  public void consultasCliente() {}
  public void consultasChofer() {}
  public void consultasVehiculo() {}

    /**
     * @return la lista de choferes
     */
    public ArrayList<Chofer> listadoChoferes() {
    ArrayList<Chofer> choferes = sistema.getChoferes();
    return choferes;
  }

    /**
     * @return la lista de clientes
     */
    public ArrayList<Cliente> listadoClientes() {
    ArrayList<Cliente> clientes = sistema.getClientes();
    return clientes;
  }

    /**
     * @return la lista de vehiculos
     */
    public ArrayList<Vehiculo> listadoVehiculos() {
    ArrayList<Vehiculo> vehiculos = sistema.getVehiculos();
    return vehiculos;
  }
  public ArrayList<ViajeAbstract> listadoViajes() {
    return sistema.listadoViajes();
  }
  public void salarioMensual() {}
  public void dineroNecesario() {}
}
