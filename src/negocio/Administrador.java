package negocio;

import java.util.ArrayList;

import Excepciones.UsuarioRepetidoException;

public class Administrador extends Usuario{
    private Sistema sistema;
	
    public Administrador(String nombreUs, String contrasenia, String nombreReal) {
		super(nombreUs, contrasenia, nombreReal);
		// TODO Auto-generated constructor stub
		sistema=Sistema.getInstance();
	}
	public Administrador() {
		sistema=Sistema.getInstance();
    }
    public void altasCliente(String username,String password,String realname) throws UsuarioRepetidoException{
    	ArrayList<Cliente> clientes=sistema.getClientes();
    	Cliente c=new Cliente(username, password, realname);
    	try {
    	for (Cliente cliAct :clientes) {
    		if (cliAct.getNombreUs() == c.getNombreUs())
    		{
    			throw new UsuarioRepetidoException();
    		}
    	}
    	clientes.add(c);
    	}catch(UsuarioRepetidoException e){
    		System.err.println("Este nombre de usuario ya existe");
    	}
    }
	public void altasChofer(){
	        
	}
	//el tipo tiene que ser el nombre del vehiculo con la primera letra en mayuscula
	public void altasVehiculo(String tipo,String patente){
		sistema.agregarVehiculo(factoryVehiculos.createVehiculo(tipo, patente));
	}
    public void modificacionesCliente(){
        
    }
    public void modificacionesChofer(){
        
    }
    public void modificacionesVehiculo(){
        
    }
	public void consultasCliente(){
        
    }
	public void consultasChofer(){
        
    }
	public void consultasVehiculo(){
        
    }
	/*
	 * listadochoferes se refiere a pasar la array list al administrador no mostrarla
    public void ListadoChoferes(){
        ArrayList<Chofer> choferes=sistema.getChoferes();
        for (Chofer chofer : choferes) {
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
    public ArrayList<Chofer> ListadoChoferes() {
    	ArrayList<Chofer> choferes=sistema.getChoferes();
    	return choferes;
	}
    public ArrayList<Cliente> ListadoClientes(){
    	ArrayList<Cliente> clientes=sistema.getClientes();
    	return clientes;
    }
    public ArrayList<Vehiculo> ListadoVehiculos(){
    	ArrayList<Vehiculo> vehiculos=sistema.getVehiculos();
    	return vehiculos;
    }
    public void ListadoViajes(){
        
    }
    public void SalarioMensual(){
        
    }
    public void Dineronecesario(){
        
    }
}