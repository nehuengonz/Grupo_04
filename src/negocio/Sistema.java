package negocio;

import java.util.ArrayList;

public class Sistema {

     private static Sistema instance;
     private ArrayList<Chofer> choferes =new ArrayList<>();
     private ArrayList<Vehiculo> vehiculos=new ArrayList<>();
     private ArrayList<Cliente> clientes=new ArrayList<>();
     private ArrayList<ViajeAbstract> viajes=new ArrayList<>();
     
  private Sistema() {
    //privado por el patron Singleton
  }

  public static Sistema getInstance() {
    if (instance == null) {
      instance = new Sistema(); // inizializa el sistema
    }
    return instance;
  }
  	//getters
    public ArrayList<Chofer> getChoferes() {
    	return choferes;
	}
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public ArrayList<ViajeAbstract> getViajes() {
		return viajes;
	}

	//metodos del sistema
    public void agregarVehiculo(Vehiculo vehiculo){
      vehiculos.add(vehiculo);
    }
    public void sacaVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }
    public void agregaChofer(Chofer chofer){
        choferes.add(chofer);
    }
    public void sacaChofer(Chofer chofer){
        choferes.remove(chofer);
    }
    public void agregaCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public void sacaCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public void agregaViaje(ViajeAbstract viaje) {
    	viajes.add(viaje);
    }
    public void sacaViaje(ViajeAbstract viaje) {
    	viajes.remove(viaje);
    }

    //devuelve un vehiculo disponible y lo pone como nodisponible, se usa en el factoryvehiculos.java
    public Vehiculo vehiculoDisponible(String clase){
      Vehiculo aux=null;
      for (Vehiculo act:vehiculos){
        if(act.getClass().getName()==clase && act.disponible==true){
          aux=act;
          aux.disponible=false;
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
