package negocio;


public class factoryVehiculos {
	private static Sistema sistema=Sistema.getInstance();

	public static Vehiculo GetVehiculoDisponible(double cantPasajeros,boolean PF,boolean baul) {
		  if (cantPasajeros == 1 && PF==false  && baul==false) {
		      return sistema.vehiculoDisponible("Moto");
		    } else if (cantPasajeros <= 4) {
		      return sistema.vehiculoDisponible("Automovil");
		    } else if(PF==false){
		      return sistema.vehiculoDisponible("Combi");
		    }else{
		    	return null;
		    }
		    	/*
		    if (cantPasajeros == 1 && PF==false  && baul==false) {
		      return new Moto(patente);
		    } else if (cantPasajeros <= 4) {
		      return new Automovil(patente);
		    } else if(PF==false){
		      return new Combi(patente);
		    }else
		    {
		    	return null;
		    	//return new Automovil("null",0);
		    }
		    {
		    	   throw new IllegalArgumentException("el vehiculo no existe para esas especificaciones");
		    }*/
	}
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


