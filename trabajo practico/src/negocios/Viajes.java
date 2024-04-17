package negocios;

import module.Pedido;
import module.Vehiculos;


public class Viajes {
    private Cliente cliente;
    private Vehiculos vehiculo;
    private Chofer chofer;
    private String zona;
    private boolean mascota;
    private boolean equipaje;
    private double Cant_pasajeros;
    private double distancia_recorrida;
    private double costo;


    public Viajes(Cliente cliente, Vehiculos vehiculo, Chofer chofer, boolean mascota, boolean equipaje,
                  double Cant_pasajeros) {
        super();
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.chofer = chofer;
        this.mascota = mascota;
        this.equipaje = equipaje;
        this.Cant_pasajeros = Cant_pasajeros;
    }
    
    //a esto se refiere con"referencia al pedido"  y "referencia al chofer''
    public Viajes(Pedido pedido, Chofer chofer) {
    }
    
    public double getCosto(){
        return 0;
    }
    public double getDistanciaRecorrida(){
        return 0;
    }
    
    
}
