package negocio;

import excepciones.UsuarioRepetidoException;

import java.time.LocalDate;
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
     * @param Nombreus nombre de usuario actual
     * @param newNombreus nuevo nombre de usuario
     * @param newpass nueva contrasenia
     * @param newName nuevo nombre
     */
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
      for(Chofer act:sistema.getChoferes()) {
    	  if(act.getDni().contains(dni)) {
    		  act.setDni(newdni);
    		  act.setNombre(nombre);
    	  }
      }
  } 
  public void modificacionesVehiculo(String nropatente,String newpatente) {
	  for (Vehiculo act:sistema.getVehiculos()) {
		  if(act.getNropatente().contains(nropatente)) {
			  act.setNropatente(newpatente);
		  }
	  }
  }
  public Cliente consultasCliente(String usuario) {
	  Cliente res=null;
	  for(Cliente act:sistema.getClientes()) {
		  if(act.getNombreUs().contains(usuario)) {
			  res=act;
		  }
	  }
	  return res;
  }
  public Chofer consultasChofer(String dni) {
	  Chofer res=null;
	  for(Chofer act:sistema.getChoferes()) {
		  if(act.getDni().contains(dni)) {
			  res=act;
		  }
	  }
	  return res;
  }
  public Vehiculo consultasVehiculo(String patente) {
	  Vehiculo res=null;
	  for(Vehiculo act:sistema.getVehiculos()) {
		  if(act.getNropatente().contains(patente)) {
			  res=act;
		  }
	  }
	  return res;
  }
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
  public void salarioMensual(Chofer chofer,LocalDate date) {
	  double salario_mensual=0;
	  for(Chofer act:sistema.getChoferes())
	  {
		
	  }
	  
  }
  
  public double dineroNecesario(LocalDate date) {
	  double totcash=0;
	  for(Chofer act:sistema.getChoferes()) {
		  if ( act instanceof ChoferPermanente) {
			totcash+=act.getSueldoBruto();  
		  }
		  else if (act instanceof ChoferTemporario) {
			  ChoferTemporario t=(ChoferTemporario)act;
			  t.setCant_viajes(date);
			  totcash+=t.getSueldoBruto();
		  }else if (act instanceof ChoferContratado) {
				  ChoferContratado c=(ChoferContratado) act;
					  totcash+= c.getSueldoBruto(date);
			  }
		  }
	  return totcash;
  }
}
