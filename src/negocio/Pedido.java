package negocio;

public class Pedido {
    private String zona;
    private boolean SPF;//service pet friendly
    private boolean tipo_quipaje;
    private String fecha;
    private double cant_pasajeros;
    private Cliente cliente;


    public Pedido(String zona, boolean SPF, boolean tipo_quipaje, String fecha,
                  double cant_pasajeros) {
        super();
        this.zona = zona;
        this.SPF = SPF;
        this.tipo_quipaje = tipo_quipaje;
        this.fecha = fecha;
        this.cant_pasajeros = cant_pasajeros;
    }

    public String getZona() {
        return zona;
    }

    public boolean isSPF() {
        return SPF;
    }

    public boolean isTipo_quipaje() {
        return tipo_quipaje;
    }

    public String getFecha() {
        return fecha;
    }


    public double getCant_pasajeros() {
        return cant_pasajeros;
    }

    public Cliente getCliente() {
        return cliente;
    }
}