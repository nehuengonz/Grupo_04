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
     * @param username
     * @param password
     * @param realname
     * @throws UsuarioRepetidoException
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
  public void altasChoferContraatdo(String dni, String nombre, double ganancia_viaje) {
	  ChoferContratado chof=new ChoferContratado(dni,nombre,ganancia_viaje);
	  sistema.agregaChofer(chof);
	  
      }
  public void altasChoferPermanente(String dni,String nombre,int sueldobasico,int aportes) {
	  ChoferPermanente chof=new ChoferPermanente(dni,nombre,sueldobasico,aportes);
	  sistema.agregaChofer(chof);
  }
  public void altasChoferTemporario(String dni, String nombre, double sueldo_basico, double aportes) {
	  ChoferTemporario chof=new ChoferTemporario(dni,nombre,sueldo_basico,aportes);
	  sistema.agregaChofer(chof);
  }
  // el tipo tiene que ser el nombre del vehiculo con la primera letra en
  // mayuscula
  public void altasVehiculo(String tipo, String patente) {
    sistema.agregarVehiculo(FactoryVehiculos.createVehiculo(tipo, patente));
  }
  //uso contains en modifica cliente
  public void modificacionesCliente(String Nombreus,String newNombreus,String newpass,String newName) {
	  
	  for(Cliente act:sistema.getClientes()) {
		  if(act.nombreUs.contains(Nombreus)) {
			  act.setNombreUs(newNombreus);
			  act.setContrasenia(newpass);
			  act.setNombreReal(newName);
			  System.out.println("datos de cliente cambiados con exito!!!");
		  }
	  }
  }
  public void modificacionesChofer(String dni, String newdni,String nombre) {
	  
  } 
  public void modificacionesVehiculo() {}
  public void consultasCliente() {}
  public void consultasChofer() {}
  public void consultasVehiculo() {}
  /*
   * listadochoferes se refiere a pasar la array list al administrador no
mostrarla public void ListadoChoferes(){ ArrayList<Chofer>
choferes=sistema.getChoferes(); for (Chofer chofer : choferes) {
          // Imprimir cada Chofer en una nueva línea
      System.out.println(chofer.toString());
  }
}

public void ListadoVehiculos(){
  ArrayList<Vehiculo> vehiculos=sistema.getVehiculos();
  for (Vehiculo vehi: vehiculos) {
          System.out.println(vehi.toString());
  }
}

public void ListadoClientes() {
  ArrayList<Cliente> clientes=sistema.getClientes();
  for(Cliente cli:clientes) {
          System.out.println(cli.toString());
  }
}
*/
  public ArrayList<Chofer> listadoChoferes() {
    ArrayList<Chofer> choferes = sistema.getChoferes();
    return choferes;
  }
  public ArrayList<Cliente> listadoClientes() {
    ArrayList<Cliente> clientes = sistema.getClientes();
    return clientes;
  }
  public ArrayList<Vehiculo> listadoVehiculos() {
    ArrayList<Vehiculo> vehiculos = sistema.getVehiculos();
    return vehiculos;
  }
  public void listadoViajes() {}
  public void salarioMensual() {}
  public void dineroNecesario() {}
}
