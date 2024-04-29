package negocio;


public class factoryVehiculos {

	//crea un vehiculo dependiendo el tipo
	public static Vehiculo createVehiculo(String tipo,String patente){
		if(tipo=="Moto"){
			return new Moto(patente);
		}else if(tipo=="Automovil"){
			return new Automovil(patente);
		}else if(tipo=="Combi"){
			return new Combi(patente);
		}else{
			return null;
		}
	}
	
	
}


