package negocio;

/**
 * patron Facotory aplicado para el viaje, 
 * este se utiliza al crear el viaje correcto cuando se realiza el pedido
 * ademas de decorarlo con el costo del baul y el costo de llevar mascota
 */
public class FactoryViaje {
	
	  public static IViaje getViaje(Pedido pedido, Vehiculo vehiculo, Chofer chofer) throws Exception {
		  	ViajeAbstract respuesta = null;
		  	ViajeAbstract encapsulado = null;
		    //si la zona esta contemplada
		    //aca agregar el decorator de baul y el decorator de mascota
		    ViajeAbstract capa1 = null;

			encapsulado = fromZona(pedido, vehiculo, chofer);
		   
		    if (encapsulado != null)
		    {
		        //se decora el viaje con el baul y la mascota
		        if (pedido.getUsaBaul()) capa1 = new ViajeConBaul(encapsulado);
		        	else capa1 = encapsulado;
		        
		        if (pedido.isSPF()) respuesta = new ViajeConMascota(capa1);
		        	else respuesta = capa1;
		    }
		    return respuesta;
		}

		public static ViajeAbstract fromZona(Pedido pedido, Vehiculo vehiculo, Chofer chofer ) throws Exception {
		  switch(pedido.getZona()) {
			  case ESTANDAR:
				  return new ViajeEstandar(pedido, vehiculo, chofer);
			  case PELIGROSA:
				  return new ViajeZonaPeligrosa(pedido, vehiculo, chofer);
			  case SIN_ASFALTAR:
				  return new ViajeCalleSinAsfaltar(pedido, vehiculo, chofer);
			  default: throw new Exception("Zona inesperada");
		  }
		}
}
