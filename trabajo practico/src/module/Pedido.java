package module;

import negocios.Cliente;

public class Pedido {
    private String zona;
    private boolean SPF;//service pet friendly
    private boolean tipo_quipaje;
    private String fecha;
    private String Tipo_servicio;
    private double cant_pasajeros;
    private Cliente cliente;


    public Pedido(String zona, boolean SPF, boolean tipo_quipaje, String fecha, String Tipo_servicio,
                  double cant_pasajeros) {
        super();
        this.zona = zona;
        this.SPF = SPF;
        this.tipo_quipaje = tipo_quipaje;
        this.fecha = fecha;
        this.Tipo_servicio = Tipo_servicio;
        this.cant_pasajeros = cant_pasajeros;
    }

}
