package negocio;

import java.util.Calendar;


/*
 * @invariant zona, SPF, usaBaul, fecha, cantPasajeros, cliente.
 */
public class Pedido {
  private Zona zona;
  private boolean SPF; // service pet friendly
  private boolean usaBaul;
  private Calendar fecha;
  private Integer cantPasajeros;
  private Cliente cliente;

  public Pedido(Zona zona, boolean SPF, boolean usaBaul,
                Integer cantPasajeros) {
    super();
    this.zona = zona;
    this.SPF = SPF;
    this.usaBaul = usaBaul;
    this.fecha = Calendar.getInstance();
    this.cantPasajeros = cantPasajeros;
  }
  

  public Pedido(Zona zona, boolean sPF, boolean usaBaul, Calendar fecha, Integer cantPasajeros) {
	super();
	this.zona = zona;
	SPF = sPF;
	this.usaBaul = usaBaul;
	this.fecha = fecha;
	this.cantPasajeros = cantPasajeros;
}


public Zona getZona() { return zona; }

  public boolean isSPF() { return SPF; }

  public boolean getUsaBaul() { return usaBaul; }

  public Calendar getFecha() { return fecha; }
  
 public void setFecha(Calendar fecha) {this.fecha = fecha;}

public Integer getCantPasajeros() { return cantPasajeros; }

  public Cliente getCliente() { return cliente; }

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

@Override
public String toString() {
	return "Pedido [zona=" + zona + ", SPF=" + SPF + ", usaBaul=" + usaBaul + ", fecha=" + fecha + ", cantPasajeros="
			+ cantPasajeros + ", cliente=" + cliente + "]";
}

  
}
