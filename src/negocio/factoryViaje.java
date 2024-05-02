package negocio;

public class factoryViaje {
	
	  public static Iviaje getviaje(Pedido pedido,Chofer chofer,Vehiculo vehiculo){
		    Iviaje respuesta=null;
		    Iviaje encapsulado=null;
		    if(pedido.getZona().equalsIgnoreCase("Zona Peligrosa"))
		        encapsulado=new ViajeZonaPeligrosa(pedido,chofer,vehiculo);
		    else if (pedido.getZona().equalsIgnoreCase("Estandar"))
		        encapsulado=new ViajeEstandar(pedido, chofer, vehiculo);
		    else if (pedido.getZona().equalsIgnoreCase("Calle sin Asfaltar"))
		        encapsulado=new ViajeCalleSinAsfaltar(pedido, chofer, vehiculo);
		    //si la zona esta contemplada
		    //aca agregar el decorator de baul y el decorator de mascota
		    Iviaje capa1=null;
		   
		    if (encapsulado !=null)
		    {
		        //se decora el viaje con el baul y la mascota
		        if (pedido.getUsaBaul()) capa1=new ViajeConBaul(encapsulado);
		        	else capa1 = encapsulado;
		        
		        if (pedido.isSPF()) respuesta=new ViajeConMascota(capa1);
		        	else respuesta=capa1;
		    }
		    return respuesta;
		}
}
